package chamdiemthi.datn.opencv_camera_1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import com.rantea.opencv_camera_1.R;

import chamdiemthi.datn.opencv_camera_1.adapter.DiemThiAdapter;
import chamdiemthi.datn.opencv_camera_1.app.Utils;
import chamdiemthi.datn.opencv_camera_1.models.BaiThi;
import chamdiemthi.datn.opencv_camera_1.models.DiemThi;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    RecyclerView rv;
    DiemThiAdapter diemThiAdapter;
    int i;
    Toolbar toolbar;
    BaiThi baiThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        toolbar = (Toolbar) findViewById(R.id.ct_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //cài đặt nút back home
        getSupportActionBar().setTitle("Xem lại");

        //lấy vị trí của bài thi trong intent gửi đến
        i = getIntent().getIntExtra(Utils.ARG_P_BAI_THI, 0);
        baiThi = Utils.dsBaiThi.get(i);
        //init
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<DiemThi> list = new ArrayList<>();
        for (int j = 0; j < Utils.dsDiemThi.size(); j++) {
            DiemThi diemThi = Utils.dsDiemThi.get(j);
            if (diemThi.maBaiThi == baiThi.maBaiThi) list.add(diemThi);
        }
        rv.setAdapter(diemThiAdapter = new DiemThiAdapter(list));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
