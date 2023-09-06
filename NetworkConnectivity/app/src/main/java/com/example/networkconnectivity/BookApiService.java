package com.example.networkconnectivity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApiService {
    @GET("volumes")
    Call<BookSearchResponse> searchBooks(
            @Query("q") String query,
            @Query("key") String apiKey
    );
}
