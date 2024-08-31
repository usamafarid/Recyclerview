package com.example.recyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE_1=1;

    private static final int REQUEST_IMAGE_PICK=2;


    private EditText plantname;
    private TextView scientificname,description,light,water,temperature,plantsize,potsize,humidity,
        propagation,location,toxity,season,instructions,plantcolor,plantfragrance,disease,plantcare,
            soiltype,maintenancelevel,lifetime,growthrate;
    private ImageView selecteimageview;
    private Button selectimage,selectfromgallery;
    private Button addplant,showplant;
    private  int [] imageresources={
            R.drawable.alovera,
            R.drawable.arecapalm
    };
    private  int imageresourceindex=0;
    private RecyclerView plantrecyclercview;
    private RecyclerView recyclerView;

    private PlantAdapter plantAdapter;
    private ArrayList<PlantModel> plantList;
    private PlantAdapter.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plantname=findViewById(R.id.plant_name);
        scientificname = findViewById(R.id.scientificname);
        description = findViewById(R.id.description);
        light = findViewById(R.id.light);
        water = findViewById(R.id.water);
        temperature = findViewById(R.id.temperature);
        plantsize = findViewById(R.id.plantsize);
        potsize = findViewById(R.id.potsize);
        humidity = findViewById(R.id.humidity);
        propagation = findViewById(R.id.propagation);
        location = findViewById(R.id.location);
        toxity = findViewById(R.id.toxity);
        season = findViewById(R.id.season);
        instructions = findViewById(R.id.instructions);
        plantcolor = findViewById(R.id.plantcolor);
        plantfragrance = findViewById(R.id.plantfragrance);
        disease = findViewById(R.id.disease);
        plantcare = findViewById(R.id.plantcare);
        soiltype = findViewById(R.id.soiltype);
        maintenancelevel = findViewById(R.id.maintenancelevel);
        lifetime = findViewById(R.id.lifetime);
        growthrate = findViewById(R.id.growthrate);

        selecteimageview=findViewById(R.id.selectedimageview);
        selectimage=findViewById(R.id.selectimage);
        selectfromgallery=findViewById(R.id.selectfromgallery);
        addplant=findViewById(R.id.addplant);
        showplant=findViewById(R.id.showplant);
        plantrecyclercview=findViewById(R.id.plantrecyclerview);

        plantList = new ArrayList<>();
        plantAdapter = new PlantAdapter(this,plantList,onItemClickListener);
        plantrecyclercview.setLayoutManager(new LinearLayoutManager(this));
        plantrecyclercview.setAdapter(plantAdapter);

        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_1);
            }
        });
       // Toolbar toolbar=findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Indoor Plants");

       // recyclerView = findViewById(R.id.recyclerview);
         /*plantList.add(new PlantModel("Alovera",R.drawable.alovera,"","","","","","","","","","","","","","","","","","","","",""));
        plantList.add(new PlantModel("Areca Palm " , R.drawable.arecapalm," Dypsis lutescens" , "Prefers partial light, keep soil moist" , " Partial Sun" , "Weekly","18-24°F","12-72 inches","Large","High","Seeds","Bedroom" ,"Non-toxic","Spring","Keep soil consistently moist but not waterlogged, well-drained soil","Green","None","Rot","Regularly check for pests, prune dead fronds","Loamy","Moderate","7-10 years","Moderate"));
        plantList.add(new PlantModel("Boston Fern" , R.drawable.bostonfern,"Nephrolepis exaltata " , "Thrives in high humidity" , "Partial Sun" , "Regular","18-24°F","12-36 inches","Medium" ,"High","Division","Terrace","Non-toxic","Spring","Mist leaves frequently, avoid direct sunlight, high humidity","Green","None","Rot","Regularly mist foliage, trim dead or damaged fronds","Peaty","Low","5-10 years","Moderate"));
        plantList.add(new PlantModel("Cast Iron Plant " , R.drawable.castironplant," Aspidistra elatior" , "Very low maintenance, tolerates low light" , "Partial Sun " , "Weekly","10-27°F","12-36 inches","Small" ,"Low","Division","Terrace","Non-toxic","Winter","Water sparingly, avoid over-watering, well-drained soil","Green","None","Rot","Avoid extreme temperatures, maintain moderate humidity levels","Sandy","Low","10- years","Slow"));
        plantList.add(new PlantModel("Chinese Evergreen " , R.drawable.chineseevergreen," Aglaonema" , "Easy to care for, tolerates low light" , "Partial Sun" , "Weekly","18-24° F","12-36 inches","Medium" ,"Medium","Division","Bedroom","Toxic to pets","Winter","Keep soil evenly moist, avoid over-watering, well-drained soil","Green","None","Rot","Wipe leaves regularly, prune brown or yellow leaves","Loamy","Low","5-10 years","Slow"));
        plantList.add(new PlantModel("Chinese Money Plant " , R.drawable.chinesemoneyplant," Pilea peperomioides" , "Likes partial light" , "Partial Sun" , "Weekly" ,"18-24°F","6-12 inches","Small","Medium","Division","Terrace","Non-toxic","Spring","Water sparingly, allow soil to dry out between waterings","Green","None","Rot","Avoid direct sunlight, rotate plant periodically to ensure even growth","Loamy","Low","5-10 years","Moderate"));
        plantList.add(new PlantModel("Croton " , R.drawable.croton,"codiaeum variegatum " , "Needs full sun for vibrant colors" , "Full Sun" , "Weekly", "18-24°F","12-48 inches","Medium","Medium","Cuttings","Kitchen","Toxic to pets","Summer","Keep soil evenly moist, provide high humidity","Green","None","Rot","Mist foliage regularly, avoid over-watering, prune to maintain shape","Sandy","Moderate","2-4 years","Moderate"));
        plantList.add(new PlantModel("Devil's Ivy " , R.drawable.devilsivy," Epipremnum aureum" , "Tolerates low light, easy to grow" , " Partial Sun" , "Weekly" ,"18-24°F","6-36 inches","Small","Low","Cuttings","Bedroom","Toxic to pets","Autumn","Water sparingly, allow soil to dry out between waterings","Green","None","Rot","Trim long stems, mist leaves occasionally","Sandy","Low","5-10 years","Fast"));
        plantList.add(new PlantModel("Dieffenbachia " , R.drawable.dieffenbachia," Dieffenbachia spp" , "Prefers partial light, keep soil moist" , " Partial Sun" , "Regular" ,"18-24°F","12-48 inches","Medium","High","Division","Gallery","Toxic to pets","Spring","Keep soil evenly moist, avoid direct sunlight","Green","None","Rot","Wear gloves when handling, wipe leaves regularly","Peaty","Low","2-5 years","Moderate"));*/
        //plantList.add(new PlantModel("Dracaena " , " Dracaena" , "Prefers partial light, water sparingly" , "Partial Sun " , "Weekly" ,"18-24°F","12-48 inches","Medium","Low","Cuttings","Kitchen","Toxic to pets","Winter","Allow soil to dry out between waterings, avoid over-watering","Green","None","Rot","Wipe leaves regularly, prune to maintain shape","Loamy","Low","5-10 years","Slow",R.drawable.dracenia));

        plantAdapter = new PlantAdapter(this,plantList,new  PlantAdapter.OnItemClickListener(){
            public  void onItemClickListener(PlantModel plantModel){
                Intent intent=new Intent(MainActivity.this, Detail_plant.class);
                intent.putExtra("",plantModel.getPlantname());
                startActivity(intent);
            }
        });
        plantrecyclercview.setAdapter(plantAdapter);
        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE_1);
            }
        });
        selectfromgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchGalleryIntent();
            }
        });
        addplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addplants();
            }
        });
        showplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plantList.isEmpty()){
                    Toast.makeText(MainActivity.this, "no plants display", Toast.LENGTH_SHORT).show();
                }
                else {
                    plantrecyclercview.setVisibility(View.VISIBLE);
                    plantAdapter.notifyDataSetChanged();

                }
            Intent intent=new Intent(MainActivity.this, Detail_plant.class);

                startActivity(intent);
            }
        });
    }

    private void dispatchGalleryIntent() {
        Intent galleryintent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryintent,REQUEST_IMAGE_PICK);
    }


    private void dispatchTakePictureIntent(int requsetcode) {
        Intent takePictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent,requsetcode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK && data!=null){
            if (requestCode==REQUEST_IMAGE_PICK){
                Uri selectimageuri=data.getData();
                if (selectimageuri!=null){
                    selecteimageview.setImageURI(selectimageuri);
                    Toast.makeText(this, "image selected", Toast.LENGTH_SHORT).show();
                }

            }
            else if (requestCode==REQUEST_IMAGE_CAPTURE_1){
            Bundle extras=data.getExtras();
            Bitmap imageBitmap=(Bitmap) extras.get("data");
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE_1:
                    selecteimageview.setImageBitmap(imageBitmap);
                    Toast.makeText(this, "image capture", Toast.LENGTH_SHORT).show();
                    break;
            }}
        }
    }
    private  void  addplants(){
     //   ArrayList<PlantModel> tempList= new ArrayList<>();

        String PlantName=plantname.getText().toString();
        String Scientificname=scientificname.getText().toString();
        String Description=description.getText().toString();
        String Light=light.getText().toString();
        String Water=water.getText().toString();
        String Temperature=temperature.getText().toString();
        String Plantsize=plantsize.getText().toString();
        String Potsize=potsize.getText().toString();
        String Humidity=humidity.getText().toString();
        String Propagation=propagation.getText().toString();
        String Location=location.getText().toString();
        String Toxity=toxity.getText().toString();
        String Season=season.getText().toString();
        String Instructions=instructions.getText().toString();
        String Plantcolor=plantcolor.getText().toString();
        String Plantfragrance=plantfragrance.getText().toString();
        String Disease=disease.getText().toString();
        String Plantcare=plantcare.getText().toString();
        String Soiltype=soiltype.getText().toString();
        String Maintenancelevel=maintenancelevel.getText().toString();
        String Lifetime=lifetime.getText().toString();
        String Growthrate=growthrate.getText().toString();

        Log.d("plant debug","plant name"+plantname);
        Log.d("plant debug","scientificname"+scientificname);
        Log.d("plant debug","description"+description);
        Log.d("plant debug","light"+light);
        Log.d("plant debug","water"+water);
        Log.d("plant debug","temperature"+temperature);
        Log.d("plant debug","plant size"+plantsize);
        Log.d("plnat debug","pot size"+potsize);
        Log.d("plant debug","humidity"+humidity);
        Log.d("panmt debug","propagation"+propagation);
        Log.d("plant debug","location"+location);
        Log.d("plant debug","toxity"+toxity);
        Log.d("plant debug","season"+season);
        Log.d("plant debud","instructions"+instructions);
        Log.d("plant debug","plant color"+plantcolor);
        Log.d("plant debug","plant fragrance"+plantfragrance);
        Log.d("plant debug","disease"+disease);
        Log.d("plant debug","plant care"+plantcare);
        Log.d("plant debug","soil type"+soiltype);
        Log.d("plant debug","miantenance level"+maintenancelevel);
        Log.d("plant debug","life time"+lifetime);
        Log.d("plant debug","growthrate"+growthrate);

        if (!PlantName.isEmpty() && selecteimageview.getDrawable()!=null && !Scientificname.isEmpty() && !Description.isEmpty() &&
                !Light.isEmpty() && !Water.isEmpty() && !Temperature.isEmpty()  && !Plantsize.isEmpty()  && !Potsize.isEmpty()
                && !Humidity.isEmpty()  && !Propagation.isEmpty()  && !Location.isEmpty()  && !Toxity.isEmpty()
                && !Season.isEmpty()  && !Instructions.isEmpty()  && !Plantcolor.isEmpty()  && !Plantfragrance.isEmpty()
                && !Disease.isEmpty()  && !Plantcare.isEmpty()  && !Soiltype.isEmpty()  && !Maintenancelevel.isEmpty()
                && !Lifetime.isEmpty()  && !Growthrate.isEmpty()){

            BitmapDrawable drawable=((BitmapDrawable) selecteimageview.getDrawable());
            Bitmap bitmap=drawable.getBitmap();

            int imageResourseId=imageresources[imageresourceindex%imageresources.length];
            imageresourceindex++;
            PlantModel plantModel=new PlantModel(PlantName,imageResourseId,Scientificname,Description,Light ,Water ,
                Temperature,Plantsize,Potsize,Humidity,Propagation,Location,Toxity,Season,Instructions,
                Plantcolor,Plantfragrance,Disease,Plantcare,Soiltype,Maintenancelevel,Lifetime,Growthrate);

        plantList.add(plantModel);
        plantAdapter.notifyDataSetChanged();
        // clear fields
        plantname.setText("");
        scientificname.setText("");
        description.setText("");
        light.setText("");
        water.setText("");
        temperature.setText("");
        plantsize.setText("");
        potsize.setText("");
        humidity.setText("");
        propagation.setText("");
        location.setText("");
        toxity.setText("");
        season.setText("");
        instructions.setText("");
        plantcolor.setText("");
        plantfragrance.setText("");
        disease.setText("");
        plantcare.setText("");
        soiltype.setText("");
        maintenancelevel.setText("");
        lifetime.setText("");
        growthrate.setText("");

        selecteimageview.setImageDrawable(null);
            Toast.makeText(this, "plant added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "please enter plant name and image", Toast.LENGTH_SHORT).show();
        }

    }
    private  void showplant(){
        plantAdapter.notifyDataSetChanged();
    }

}
