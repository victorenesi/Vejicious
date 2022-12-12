package uk.ac.tees.b1196119.vejicious.Interface;

import uk.ac.tees.b1196119.vejicious.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> responses,String message);
    void didError(String message);
}
