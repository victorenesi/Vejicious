package uk.ac.tees.b1196119.vejicious.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import uk.ac.tees.b1196119.vejicious.Interface.RecipeClickListner;
import uk.ac.tees.b1196119.vejicious.Models.SimilarRecipeResponse;
import uk.ac.tees.b1196119.vejicious.R;

import java.util.List;

import uk.ac.tees.b1196119.vejicious.R;

public class SimilarRecipeAdapter extends RecyclerView.Adapter< SimilarRecipeViewHolder>{

    Context context;
    List<SimilarRecipeResponse>list;
    RecipeClickListner listner;

    public SimilarRecipeAdapter(Context context, List<SimilarRecipeResponse> list, RecipeClickListner listner) {
        this.context = context;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public SimilarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_similar_recipe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarRecipeViewHolder holder, int position) {
    holder.textView_similar_title.setText(list.get(position).title);
    holder.textView_similar_title.setSelected(true);
    holder.textView_similar_serving.setText(list.get(position).servings+"Person");
        Picasso.get().load(" https://spoonacular.com/recipeImages"+list.get(position).id+"-556x370."+list.get(position).imageType)
        .into(holder.imageView_similar);

        holder.similar_recipe_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listner.onRecipeClicked(String.valueOf( list.get(holder.getAdapterPosition()).id));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {

 CardView similar_recipe_holder;
 TextView textView_similar_title,textView_similar_serving;
 ImageView imageView_similar;

    public SimilarRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        similar_recipe_holder= itemView.findViewById(R.id.similar_recipe_holder);
        textView_similar_title = itemView.findViewById(R.id.textView_similar_title);
        textView_similar_serving = itemView.findViewById(R.id.textView_similar_serving);



    }
}
