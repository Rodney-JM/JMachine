package org.JMachine.domain.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GroqService {
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private final HttpClient client;
    private final Gson gson;
    private final String apiKey;

    public GroqService(){
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();

        this.apiKey = System.getenv("GROQ_API_KEY");

        if(this.apiKey == null || this.apiKey.isBlank()){
            System.out.println("GROQ API KEY não configurada. IA desabilitada");
        }
    }

    public String identifyCorrectAnswer(String questionText, List<String> alternatives) throws Exception {
        if(apiKey ==null || apiKey.isBlank()){
            System.out.println("Configure GROQ API KEY para usar a IA");
            return null;
        }

        try{
            String prompt = buildPrompt(questionText, alternatives);
            String response = callGroqAPI(prompt);

            // Retorno da IA
            String correctAnswer = response.trim();

            //Esta nas alternativas
            for(String alt : alternatives){
                if(alt.trim().equalsIgnoreCase(correctAnswer.trim())){
                    return alt;
                }

                //Verificar se contem com pont
                if(alt.contains(correctAnswer) || correctAnswer.contains(alt)){
                    return alt;
                }
            }

            //Se não encontrar o match exato, retorna o mais prox

            return findBestMatch(correctAnswer, alternatives);
        }catch(Exception e){
            System.out.println("Erro ao consutar o Groq: " + e.getMessage());
            return null;
        }
    }

    private String buildPrompt(String questionText, List<String> alternatives){
        StringBuilder prompt = new StringBuilder();

        prompt.append("Você é um especialista em educação. Analise a questão e identifique a alternativa correta");
        prompt.append("QUESTÃO: ").append(questionText).append("\n\n");

        prompt.append("ALTERNATIVAS: \n");

        for(int i = 0; i< alternatives.size(); i++){
            prompt.append((char)('A' + i)).append(") ").append(alternatives.get(i)).append("\n");
        }
        prompt.append("\nIMPORTANTE: Retorne APENAS o texto exato da alternativa correta, sem a letra, sem explicação, sem pontuação extra");
        prompt.append("Exemplo: Se a alternativa B 'extends' está correta, retorne apenas: extends");

        return prompt.toString();
    }

    private String callGroqAPI(String prompt) throws Exception{
        JsonArray messages = new JsonArray();

        JsonObject userMessage = new JsonObject();
        userMessage.addProperty("role", "user");
        userMessage.addProperty("content", prompt);
        messages.add(userMessage);

        //Construindo o request body
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("model", "llama-3.1-70b-versatile");
        requestBody.add("messages", messages);
        requestBody.addProperty("temperature", 0.3);
        requestBody.addProperty("max_tokens", 100);


        //requests http
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+ apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(requestBody)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() !=200){
            throw new RuntimeException("Groq API erro " + response.statusCode() + ": " + response.body());
        }

        JsonObject responseJson = gson.fromJson(response.body(), JsonObject.class);

        String text = responseJson.getAsJsonArray("choices")
                .get(0).getAsJsonObject()
                .getAsJsonObject("message")
                .get("content").getAsString();

        return text.trim();
    }

    private String findBestMatch(String target, List<String> alternatives){
        String targetLower = target.toLowerCase().trim();


        //busca exata
        for(String alt : alternatives){
            if(alt.trim().equalsIgnoreCase(targetLower)){
                return alt;
            }
        }

        // Busca por substring
        for(String alt : alternatives){
            String altLower = alt.toLowerCase().trim();
            if(altLower.contains(targetLower) || targetLower.contains(altLower)){
                return alt;
            }
        }

        //Busca por palavras em comum
        String[] targetWords = targetLower.split("\\s+");
        int maxMatches = 0;
        String bestMatch = alternatives.get(0);

        for(String alt: alternatives){
            String altLower = alt.toLowerCase();
            int matches = 0;

            for(String word : targetWords){
                if(altLower.contains(word)){
                    matches++;
                }
            }

            if(matches > maxMatches){
                maxMatches = matches;
                bestMatch = alt;
            }
        }

        return bestMatch;
    }


}
