package com.tsel.multimatics.myshoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static android.view.View.*;

public class DetailProductActivity extends AppCompatActivity implements
        OnClickListener{

    private TextView tvName, tvPrice, tvDesc;
    private Button btnAddChart;
    private ImageView imgDetail;

    private ImageView[] imgThumb = new ImageView[4];
    private Spinner spinner;

    final private String DESKRIPSI = "Tambora diciptakan untuk teman berpetualang, apapun aktivitasnya. Sesuai namanya yang gahar, " +
            "Tambora siap menapaki jalan bebatuan, kerikil terjal, tanpa perlu khawatir. Tambora melindungi kaki Brothers dengan baik. " +
            "Desainnya yang hi-cut akan menutupi mata kaki dengan lapisan dalam yang lembut sehingga lebih aman dan nyaman dalam setiap kegiatan. " +
            "Toe-box yang besar sehingga ujung kaki memiliki ruang gerak yang lebih besar, menggunakan material kulit asli yang berkualitas sehingga awet sampe ke anak-cucu. " +
            "Tambora menggunakan sole TPR (thermoplastic rubber) agar ringan dan tidak cepat abrasi. Eyelet-nya dikombinasikan dengan hook agar Tambora mudah diikat.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        btnAddChart = (Button) findViewById(R.id.add_to_chart);

        imgDetail = (ImageView) findViewById(R.id.img_detail);

        imgThumb[0] = (ImageView) findViewById(R.id.img_thumb1);
        imgThumb[1] = (ImageView) findViewById(R.id.img_thumb2);
        imgThumb[2] = (ImageView) findViewById(R.id.img_thumb3);
        imgThumb[3] = (ImageView) findViewById(R.id.img_thumb4);

                spinner = (Spinner) findViewById(R.id.spinner_size);

        getSupportActionBar().setTitle("Detail Product");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Product selected_product = getIntent().getParcelableExtra("product");

        tvName.setText(selected_product.getName());
        tvPrice.setText(selected_product.getPrice());
        tvDesc.setText(DESKRIPSI);
        Glide.with(DetailProductActivity.this).load(selected_product.getImageURL()).into(imgDetail);

        for (int i = 0; i < imgThumb.length; i++) {
            Glide.with(DetailProductActivity.this).load(SampleData.thumb[i]).into(imgThumb[i]);
            imgThumb[i].setOnClickListener(this);
        }


        String size[] = new String[] {
                "Pilih Ukuran", "37", "38" , "39", "40",
                "41", "42", "43"
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, android.R.id.text1, size);

        spinner.setAdapter(spinnerArrayAdapter);

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String imageURL = null;
        switch (view.getId()) {
            case R.id.img_thumb1:
                imageURL = SampleData.thumb[0];
                break;
            case R.id.img_thumb2:
                imageURL = SampleData.thumb[1];
                break;
            case R.id.img_thumb3:
                imageURL = SampleData.thumb[2];
                break;
            case R.id.img_thumb4:
                imageURL = SampleData.thumb[3];
                break;
        }

        if (imageURL != null) {
            Glide.with(DetailProductActivity.this).load(imageURL).into(imgDetail);
        }
    }
}
