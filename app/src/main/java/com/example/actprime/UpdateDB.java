package com.example.actprime;

/**
 public class MakeDB extends AppCompatActivity {

 TextView welcome;
 Intent intent1, intent2;
 CalendarView DateSelect;
 View dialogView;

 @Override
 protected void onCreate(Bundle savedInstance) {

 Date startdate = new Date(DateSelect.getDate());

 }

 public void SendDate(int startdate, int enddate) {

 }

 LayoutInflater inflater = getLayoutInflater();
 View layout = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.dialog));


 dialogView = (View) View.inflate(SignupActivity.this, R.layout.dialog, null);

 DateSelect = layout.findViewById(R.id.DateSelect);
 Date startdate = new Date(DateSelect.getDate());
 Date enddate = new Date(DateSelect.getDate() + 7);

 Intent intent = getIntent();
 final String name = intent.getStringExtra("name");
 welcome.setText(name + "님 안녕하세요! 이 아이디로 계속하실건가요?");


 }
 **/