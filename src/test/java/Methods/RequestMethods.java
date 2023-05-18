package Methods;

import io.qameta.allure.internal.shadowed.jackson.databind.util.JSONPObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestMethods {
    WebDriver driver;

    public RequestMethods(WebDriver driver){
        this.driver = driver;
    }

    public void registerRequest(){
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://sisprogress.online/register/ForTest"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"type\":\"mobile\"}"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
