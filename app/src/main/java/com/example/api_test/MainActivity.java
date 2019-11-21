package com.example.api_test;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.56, 126.97);
        LatLng ANSOUNG = new LatLng (37.53, 126.98 );

        MarkerOptions markeransoung = new MarkerOptions();
        markeransoung.position(ANSOUNG);
        markeransoung.title("안성");
        markeransoung.snippet("우리동네");
        mMap.addMarker(markeransoung);

        MarkerOptions markerSouel = new MarkerOptions();
        markerSouel.position(SEOUL);
        markerSouel.title("서울");
        markerSouel.snippet("한국의 수도");
        mMap.addMarker(markerSouel);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

}