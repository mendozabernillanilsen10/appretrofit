package com.example.library.format.body;

public class pp {

    private void cargarDatos(String fullUrl) {
        String baseUrl = obtenerBaseUrl(fullUrl);
        String endpoint = obtenerEndpoint(fullUrl);

        Log.d("URL", "URL base: " + baseUrl);
        Log.d("URL", "Endpoint: " + endpoint);

        Retrofit retrofit = construirRetrofit(baseUrl);
        if (retrofit == null) {
            return;
        }
        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);


        Call<List<Object>> call = interfaceApi.getData(endpoint);
        realizarLlamadaApi(call);
    }

    private String obtenerBaseUrl(String fullUrl) {
        if (fullUrl.trim().isEmpty()) {
            mostrarMensajeEmergente("Ingrese una URL válida");
            return "";
        }

        int lastSlashIndex = fullUrl.lastIndexOf("/");
        if (lastSlashIndex != -1) {
            return fullUrl.substring(0, lastSlashIndex + 1); // Incluyendo "/"
        } else {
            mostrarMensajeEmergente("URL no válida. La URL debe contener al menos un '/'");
            return "";
        }
    }

    private String obtenerEndpoint(String fullUrl) {
        int lastSlashIndex = fullUrl.lastIndexOf("/");
        if (lastSlashIndex != -1) {
            return fullUrl.substring(lastSlashIndex + 1); // Excluyendo "/"
        } else {
            return "";
        }
    }

    private Retrofit construirRetrofit(String baseUrl) {

        if (baseUrl.isEmpty()) {
            return null;
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
