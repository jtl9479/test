package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSelecDate1;    //달력 생성 버튼
    Button btnSelecDate2;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// ActionBar에 타이틀 변경
        getSupportActionBar().setTitle("냉장고를 부탁해");
// ActionBar의 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
// 홈 아이콘 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSelecDate1=(Button)findViewById(R.id.button2); //날짜
        btnSelecDate2=(Button)findViewById(R.id.button3);

    }

    public void onClick(View v){
        if(v == btnSelecDate1) {
            final Calendar c = Calendar.getInstance();//현재 시간을 가진다.
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btnSelecDate1.setText( year+"/" +dayOfMonth + "/" + (month + 1)  );
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }//등록일과 유통기한 달력불러오기
        if(v == btnSelecDate2) {
            final Calendar c = Calendar.getInstance();//현재 시간을 가진다.
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btnSelecDate2.setText( year+"/" +dayOfMonth + "/" + (month + 1)  );
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }//등록일과 유통기한 달력불러오기

        final Dialog loginDialog = new Dialog(this); //등록하기 커스텀 대화 상자 생성
        loginDialog.setContentView(R.layout.checkbox);
        loginDialog.setTitle("등록 화면");

        Button check = (Button) loginDialog.findViewById(R.id.check);
        Button cancel = (Button) loginDialog.findViewById(R.id.cancel);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"등록되었습니다",Toast.LENGTH_LONG).show();

                loginDialog.dismiss();

                Toast.makeText(getApplicationContext(),"취소되었습니다",Toast.LENGTH_LONG).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                loginDialog.dismiss();
            }
        });
        loginDialog.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_btn1:
                playBtn();
                return true;
            case R.id.action_btn2:
                stopBtn();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void playBtn() {
    }
    private void stopBtn() {
    }
}