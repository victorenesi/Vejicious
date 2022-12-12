package uk.ac.tees.b1196119.vejicious.Interface;

import uk.ac.tees.b1196119.vejicious.Models.RecipeDetailsResponse;

public interface RecipeDetailsListener {
    void didFetch(RecipeDetailsResponse response,String message);
    void didError(String message);
}
