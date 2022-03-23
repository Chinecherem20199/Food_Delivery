package nigeriandailies.com.ng.fooddelivery.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import nigeriandailies.com.ng.fooddelivery.R;
import nigeriandailies.com.ng.fooddelivery.model.RestaurantModel;

public class ResturantListAdapter extends RecyclerView.Adapter<ResturantListAdapter.MyViewHolder> {

    private List<RestaurantModel> mRestaurantModelList;
    private RestuarantListClickListerner clickListerner;


    public ResturantListAdapter(List<RestaurantModel> mRestaurantModelList, RestuarantListClickListerner clickListerner){
        this.mRestaurantModelList = mRestaurantModelList;
        this.clickListerner = clickListerner;
    }
    public void updateData(List<RestaurantModel> mRestaurantModels){
        this.mRestaurantModelList = mRestaurantModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResturantListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_role, parent, false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantListAdapter.MyViewHolder holder, int position) {
        holder.restuarantName.setText("Name: " +mRestaurantModelList.get(position).getName());
        holder.restuarantAddress.setText("Address: " +mRestaurantModelList.get(position).getAddress());
        holder.restuarantHours.
                setText("Today's hours: " +mRestaurantModelList.get(position)
                        .getHours().getTodaysHours());

        //Here is where is fetching the items being click in the position
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListerner.onItemClick(mRestaurantModelList.get(position));
            }
        });

      //Adding Image to the glide
        Glide.with(holder.thumpImage)
                .load(mRestaurantModelList.get(position).getImage())
                .into(holder.thumpImage);
    }
    @Override
    public int getItemCount() {
        return mRestaurantModelList.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
            TextView restuarantName;
            TextView restuarantAddress;
            TextView restuarantHours;
            ImageView thumpImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restuarantName = itemView.findViewById(R.id.restuarantName);
            restuarantAddress = itemView.findViewById(R.id.restuarantAddress);
            restuarantHours = itemView.findViewById(R.id.restuarantHours);
            thumpImage = itemView.findViewById(R.id.thumpImage);


        }
    }
    //Handling the click on the list
    public interface RestuarantListClickListerner{
        public void onItemClick(RestaurantModel restaurantModel);

    }
}
