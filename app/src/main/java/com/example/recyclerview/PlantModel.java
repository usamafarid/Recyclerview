package com.example.recyclerview;

public class PlantModel {

    private final String plantname;
    private final int imageResourceid;
    private final String scientificname;
    private final String description;
    private final String light;
    private final String water;
    private final String temperature;
    private final String plantsize;
    private final String potsize;
    private final String humidity;
    private final String propagation;
    private final String location;
    private final String toxity;
    private final String season;
    private final String instructions;
    private final String plantcolor;
    private final String plantfragrance;
    private final String disease;
    private final String plantcare;
    private final String soiltype;
    private final String maintenancelevel;
    private final String lifetime;
    private final String growthrate;
    // private String name;
   //  private String imageuri;



    public PlantModel(String plantname, int imageResourceid, String scientificname, String description,
                      String light, String water, String temperature, String plantsize, String potsize,
                      String humidity, String propagation, String location, String toxity, String season,
                      String instructions, String plantcolor, String plantfragrance, String disease,
                      String plantcare, String soiltype, String maintenancelevel, String lifetime,
                      String growthrate) {
     //   this.name=name;
     //   this.imageuri=imageuri;


        this.imageResourceid=imageResourceid;
        this.plantname=plantname;
        this.scientificname=scientificname;
        this.description=description;
        this.light=light;
        this.water=water;
        this.temperature=temperature;
        this.plantsize=plantsize;
        this.potsize=potsize;
        this.humidity=humidity;
        this.propagation=propagation;
        this.location=location;
        this.toxity=toxity;
        this.season=season;
        this.instructions=instructions;
        this.plantcolor=plantcolor;
        this.plantfragrance=plantfragrance;
        this.disease=disease;
        this.plantcare=plantcare;
        this.soiltype=soiltype;
        this.maintenancelevel=maintenancelevel;
        this.lifetime=lifetime;
        this.growthrate=growthrate;
    }

   // public String getName(){
     //   return name;
    //}
  //  public String getImageuri(){
    //    return  imageuri;
    //}
   public int getImageResourceid() {
        return imageResourceid;
    }

    public  String getPlantname(){
        return plantname;
    }
    public  String getScientificname(){
        return scientificname;
    }
    public String getDescription(){
        return description;
    }
    public String getLight() {
        return light;
    }
    public String getWater(){
        return water;
    }
    public String getTemperature(){
        return temperature;
    }
    public String getPlantsize(){
        return  plantsize;
    }
    public  String getPotsize(){
        return potsize;
 }
    public  String getHumidity(){
        return  humidity;
 }
    public  String getPropagation(){
        return  propagation;
 }
    public  String getLocation(){
        return  location;
 }
    public  String getToxity(){
        return  toxity;
 }
    public String getSeason(){
        return  season;
 }
    public String getInstructions(){
        return  instructions;
}
    public  String getPlantcolor(){
        return  plantcolor;
}
    public  String getPlantfragrance(){
        return  plantfragrance;
}
    public String getDisease(){
        return  disease;
}
    public  String getPlantcare(){
        return  plantcare;
}
    public String getsoiltype(){
        return soiltype;
}
    public  String getMaintenancelevel(){
        return  maintenancelevel;
}
    public  String getLifetime(){
        return  lifetime;
}
    public  String getGrowthrate(){
        return  growthrate;
}

}
