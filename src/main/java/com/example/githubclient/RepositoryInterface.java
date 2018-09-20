package com.example.githubclient;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RepositoryInterface {
    @GET("user/repos")
    Call<List<Repository>> listRepos(@Header("Authorization") String accessToken,
                                     @Header("Accept") String apiVersionSpec);

    @DELETE("repos/{owner}/{repo}")
    Call<DeletePayload> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                                   @Path("repo") String repo, @Path("owner") String owner);

    @POST("user/repos")
    Call<Repository> createRepo(@Body Repository repo, @Header("Authorization") String accessToken,
                                      @Header("Accept") String apiVersionSpec,
                                      @Header("Content-Type") String contentType);
}