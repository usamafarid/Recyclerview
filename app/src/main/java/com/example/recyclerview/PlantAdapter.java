package com.example.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {

    private final List<PlantModel> plantList;
    private final Context context ;
    public final  OnItemClickListener onItemClickListener;
    public PlantAdapter(Context context,List<PlantModel> plantList,OnItemClickListener onItemClickListener) {
        this.context=context;
        this.plantList = plantList;
        this.onItemClickListener=onItemClickListener;

    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        PlantModel plant = plantList.get(position);

        holder.imageView.setImageResource(plant.getImageResourceid());
        holder.Plantname.setText(plant.getPlantname());
        holder.scientificname.setText(plant.getScientificname());
        holder.description.setText(plant.getDescription());
        holder.light.setText(plant.getLight());
        holder.water.setText(plant.getWater());
        holder.temperature.setText(plant.getTemperature());
        holder.plantsize.setText(plant.getPlantsize());
        holder.potsize.setText(plant.getPotsize());
        holder.humidity.setText(plant.getHumidity());
        holder.propagation.setText(plant.getPropagation());
        holder.location.setText(plant.getLocation());
        holder.toxity.setText(plant.getToxity());
        holder.season.setText(plant.getSeason());
        holder.instruction.setText(plant.getInstructions());
        holder.plantcolor.setText(plant.getPlantcolor());
        holder.plantfragrance.setText(plant.getPlantfragrance());
        holder.disease.setText(plant.getDisease());
        holder.plantcare.setText(plant.getPlantcare());
        holder.soiltype.setText(plant.getsoiltype());
        holder.maintenancelevel.setText(plant.getMaintenancelevel());
        holder.lifetime.setText(plant.getLifetime());
        holder.growthrate.setText(plant.getGrowthrate());


       holder.itemView.setOnClickListener(view -> {

            Intent intent=new Intent(context, Detail_plant.class);

            intent.putExtra("",plant.getPlantname());
            intent.putExtra("scientificname",plant.getScientificname());
            intent.putExtra("description",plant.getDescription());
            intent.putExtra("light",plant.getLight());
            intent.putExtra("water",plant.getWater());
            intent.putExtra("temperature",plant.getTemperature());
            intent.putExtra("plantsize",plant.getPlantsize());
            intent.putExtra("potsize",plant.getPotsize());
            intent.putExtra("humidity",plant.getHumidity());
            intent.putExtra("propagation",plant.getPropagation());
            intent.putExtra("location",plant.getLocation());
            intent.putExtra("toxity",plant.getToxity());
            intent.putExtra("season",plant.getSeason());
            intent.putExtra("instructions",plant.getInstructions());
            intent.putExtra("plantcolor",plant.getPlantcolor());
            intent.putExtra("plantfragrance",plant.getPlantfragrance());
            intent.putExtra("disease",plant.getDisease());
            intent.putExtra("plantcare",plant.getPlantcare());
            intent.putExtra("soiltype",plant.getsoiltype());
            intent.putExtra("maintenancelevel",plant.getMaintenancelevel());
            intent.putExtra("lifetime",plant.getLifetime());
            intent.putExtra("growthrate",plant.getGrowthrate());

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public interface OnItemClickListener {
        void onItemClickListener(PlantModel plantModel);
    }

    public static class PlantViewHolder extends RecyclerView.ViewHolder {
         ImageView imageView;
        TextView Plantname,scientificname,description,light,water,temperature,plantsize,potsize,
                humidity,propagation,location,toxity,season,instruction,plantcolor,plantfragrance,
                disease,plantcare,soiltype,maintenancelevel,lifetime,growthrate;

        public PlantViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Default);
            Plantname=itemView.findViewById(R.id.plant_name);
            scientificname=itemView.findViewById(R.id.scientificname);
            description=itemView.findViewById(R.id.description);
            light=itemView.findViewById(R.id.light);
            water=itemView.findViewById(R.id.water);
            temperature=itemView.findViewById(R.id.temperature);
            plantsize=itemView.findViewById(R.id.plantsize);
            potsize=itemView.findViewById(R.id.potsize);
            humidity=itemView.findViewById(R.id.humidity);
            propagation=itemView.findViewById(R.id.propagation);
            location=itemView.findViewById(R.id.location);
            toxity=itemView.findViewById(R.id.toxity);
            season=itemView.findViewById(R.id.season);
            instruction=itemView.findViewById(R.id.instructions);
            plantcolor=itemView.findViewById(R.id.plantcolor);
            plantfragrance=itemView.findViewById(R.id.plantfragrance);
            disease=itemView.findViewById(R.id.disease);
            plantcare=itemView.findViewById(R.id.plantcare);
            soiltype=itemView.findViewById(R.id.soiltype);
            maintenancelevel=itemView.findViewById(R.id.maintenancelevel);
            lifetime=itemView.findViewById(R.id.lifetime);
            growthrate=itemView.findViewById(R.id.growthrate);
        }
    }
}
