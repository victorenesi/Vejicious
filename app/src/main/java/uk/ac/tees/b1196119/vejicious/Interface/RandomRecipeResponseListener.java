package uk.ac.tees.b1196119.vejicious.Interface;

import uk.ac.tees.b1196119.vejicious.Models.RandomRecipeApiResponse;

public interface RandomRecipeResponseListener {
    void didFetch(RandomRecipeApiResponse response,String message);
    void didError(String message);
}
