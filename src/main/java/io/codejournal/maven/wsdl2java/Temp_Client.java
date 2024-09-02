package io.codejournal.maven.wsdl2java;

import okhttp3.*;

import java.io.IOException;

public class Temp_Client {
    private static final String SOAP_ENDPOINT = "https://www.w3schools.com/xml/tempconvert.asmx";
    static String temp_client(String soapRequest) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(soapRequest, MediaType.get("text/xml; charset=utf-8"));
        Request request = new Request.Builder()
                .url(SOAP_ENDPOINT)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
