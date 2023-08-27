package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    TextView tv;
    Button btn;

    private ArrayList list = new ArrayList();
    private HashMap item;
    private SimpleAdapter sa;

    private String[][] doctor_details1 = {

            {"Doctor Name : John Wick", "Hospital Address : Canada", "Exp : 5yrs", "Mobile No : 1212312121", "212"},
            {"Doctor Name : Jane Doe", "Hospital Address : USA", "Exp : 8yrs", "Mobile No : 9876543210", "105"},
            {"Doctor Name: Emily Smith", "Hospital Address: UK", "Exp: 10yrs", "Mobile No: 5551234567", "302"},
            {"Doctor Name: Michael Johnson", "Hospital Address: Australia", "Exp: 12yrs", "Mobile No: 1234567890", "415"},
            {"Doctor Name: Kim Johnson", "Hospital Address: Australia", "Exp: 12yrs", "Mobile No: 1234567890", "415"},
            {"Doctor Name: Belly John", "Hospital Address: Germany", "Exp: 14yrs", "Mobile No: 121324443", "445"}
    };

    private String[][] doctor_details2 = {

            {"Doctor Name : Singye Wick", "Hospital Address : China", "Exp : 3yrs", "Mobile No : 1233121", "212"},
            {"Doctor Name : Dorji Doe", "Hospital Address : Bhutan", "Exp : 6yrs", "Mobile No : 1213223", "105"},
            {"Doctor Name: Kinley Smith", "Hospital Address: UK", "Exp: 7yrs", "Mobile No: 321212", "302"},
            {"Doctor Name: Aniketh Johnson", "Hospital Address: India", "Exp: 12yrs", "Mobile No: 31212312", "415"},
            {"Doctor Name: Sonam Johnson", "Hospital Address: Australia", "Exp: 11yrs", "Mobile No: 12131312", "415"},
            {"Doctor Name: Namgay John", "Hospital Address: Germany", "Exp: 12yrs", "Mobile No: 21213212", "445"}
    };
    private String[][] doctor_details3 = {

            {"Doctor Name : Pema Jamtsho", "Hospital Address : Bhutan", "Exp : 3yrs", "Mobile No : 1233121", "212"},
            {"Doctor Name : Kinzang Namgay", "Hospital Address : Korean", "Exp : 6yrs", "Mobile No : 1213223", "105"},
            {"Doctor Name: Kinley Lhamo", "Hospital Address: Egypt", "Exp: 7yrs", "Mobile No: 321212", "302"},
            {"Doctor Name: Aniketh Powdel", "Hospital Address: India", "Exp: 12yrs", "Mobile No: 31212312", "415"},
            {"Doctor Name: Sonam Phuentsho", "Hospital Address: Australia", "Exp: 11yrs", "Mobile No: 12131312", "415"},
            {"Doctor Name: Tshering Jamtsho", "Hospital Address: Germany", "Exp: 12yrs", "Mobile No: 21213212", "445"}
    };

    private String[][] doctor_details4 = {

            {"Doctor Name : Tsheten Dorji", "Hospital Address : Bhutan", "Exp : 3yrs", "Mobile No : 1233121", "212"},
            {"Doctor Name : Sonam Tenzin", "Hospital Address : Canada", "Exp : 6yrs", "Mobile No : 1213223", "105"},
            {"Doctor Name: Sherab Wangmo", "Hospital Address: UK", "Exp: 7yrs", "Mobile No: 321212", "302"},
            {"Doctor Name: Pema Norbu", "Hospital Address: Japan", "Exp: 12yrs", "Mobile No: 31212312", "415"},
            {"Doctor Name: Sonam Phuentsho", "Hospital Address: Russian", "Exp: 11yrs", "Mobile No: 12131312", "415"},
            {"Doctor Name: Tshering Wangmo", "Hospital Address: Bangladesh", "Exp: 12yrs", "Mobile No: 21213212", "445"}
    };
    private String[][] doctor_details5 = {

            {"Doctor Name : Dechen Wangmo", "Hospital Address : Bhutan", "Exp : 3yrs", "Mobile No : 1233121", "212"},
            {"Doctor Name : Namgay Lhamo", "Hospital Address : Korean", "Exp : 6yrs", "Mobile No : 1213223", "105"},
            {"Doctor Name: Pema Tshering", "Hospital Address: Egypt", "Exp: 7yrs", "Mobile No: 321212", "302"},
            {"Doctor Name: Sonu Powdel", "Hospital Address: India", "Exp: 12yrs", "Mobile No: 31212312", "415"},
            {"Doctor Name: Keza Phuentsho", "Hospital Address: Australia", "Exp: 11yrs", "Mobile No: 12131312", "415"},
            {"Doctor Name: Phub Jamtsho", "Hospital Address: Germany", "Exp: 12yrs", "Mobile No: 21213212", "445"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        String[][] doctor_details = {};
        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;

        else if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;

        else if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details3;

        else if (title.compareTo("Dentists")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn = findViewById(R.id.buttonDDBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });


        for (int i = 0; i < doctor_details.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees: "+ doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);



    }
}