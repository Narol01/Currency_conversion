package ait.fixer;

import ait.fixer.dto.ReqQuery;
import ait.fixer.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Scanner;

public class FixerAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter what you want to sell");
        String from = scanner.nextLine();
        System.out.println("Enter what you want to buy");
        String to = scanner.nextLine();
        System.out.println("Enter amount");
        String amount= scanner.nextLine();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();


        headers.add("apikey","ZP72y0D4rD1DHj9p1QWvxcKaqzk067tQ");
        UriComponentsBuilder builder= builderConstructor(amount,from,to);
        URI url =builder.build().toUri();
        RequestEntity<String> request =new RequestEntity<>(headers, HttpMethod.GET,url);
        ResponseEntity<ResponseDto> response =restTemplate.exchange(request,ResponseDto.class);
        ResponseDto responseBody = response.getBody();
        resultDisplay(responseBody);

    }

    private static void resultDisplay(ResponseDto responseBody) {
        if (responseBody != null && responseBody.isSuccess()) {
            System.out.println(responseBody.getQuery());
            System.out.println(responseBody.getInfo());
            System.out.println(" You bought " + responseBody.getResult() +" "+ responseBody.getQuery().getTo());
        } else {
            System.out.println("Failed to get response.");
        }
    }

    private static UriComponentsBuilder builderConstructor(String amount,String from,String to) {
        return UriComponentsBuilder.fromHttpUrl("https://api.apilayer.com/fixer/convert")
                .queryParam("to",to)
                .queryParam("from",from)
                .queryParam("amount",amount);
    }

}
