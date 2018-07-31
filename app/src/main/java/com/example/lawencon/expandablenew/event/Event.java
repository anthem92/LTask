package com.example.lawencon.expandablenew.event;

import android.app.DatePickerDialog;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lawencon.expandablenew.ExpandableListAdapter;
import com.example.lawencon.expandablenew.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Event extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    // this is for the Drawer Layout
    private DrawerLayout mDrawerLayout;
    RelativeLayout toolbarMenuRL;

    // this is for calendar
    ImageView startDateSearchImage, endDateSearchImage;
    TextView tvStartDateSEARCH, tvEndDateSEARCH;
    DatePickerDialog datePickerDialog_Start, datePickerDialog_End;
    SimpleDateFormat dateFormatter_Start, dateFormatter_End;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ButtonToShowDrawer();

        DrawerWithExpandbleListView();

        //below code for the Start date using Calendar
        dateFormatter_Start = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvStartDateSEARCH = (TextView) findViewById(R.id.tvstartDateSearch_EventActvty);
        startDateSearchImage = (ImageView) findViewById(R.id.startDateImg_SEARCH_EventActivity);
        startDateSearchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_startDate();
            }
        });

        //below code for the End date using Calendar
        dateFormatter_End = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvEndDateSEARCH = (TextView) findViewById(R.id.tvendDateSearch_EventActvty);
        endDateSearchImage = (ImageView) findViewById(R.id.endDateImg_SEARCH_EventActivity);
        endDateSearchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_endDate();
            }
        });


    }

    private void ButtonToShowDrawer(){

        //this is for the button drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbarMenuRL = (RelativeLayout) findViewById(R.id.toolbarMenuRL);

        toolbarMenuRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    private void DrawerWithExpandbleListView(){
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.ELV_menu);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                //Toast.makeText(getApplicationContext(),
                //"Group Clicked " + listDataHeader.get(groupPosition),
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });


        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }

    //Preparing the list data
    private void prepareListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        //child data
        listDataHeader.add("Profile");
        listDataHeader.add("Time Management");

        List<String> profile = new ArrayList<String>();
        profile.add("Personal Detail");
        profile.add("Employee Profile");

        List<String> timeManagement = new ArrayList<String>();
        timeManagement.add("Leave Request");
        timeManagement.add("Overtime Request");
        timeManagement.add("Event");
        timeManagement.add("Time Sheet");
        timeManagement.add("Permit Request");
        timeManagement.add("Overtime Order");
        timeManagement.add("Work Sheet");

        listDataChild.put(listDataHeader.get(0), profile );
        listDataChild.put(listDataHeader.get(1), timeManagement);
    }

    //Calender for searching start date
    private void search_startDate(){
        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog_Start = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvStartDateSEARCH.setText(dateFormatter_Start.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // to show the datePicker
        datePickerDialog_Start.show();
    }

    //Calender for searching end date
    private void search_endDate(){
        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog_End = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvEndDateSEARCH.setText(dateFormatter_End.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // to show the datePicker
        datePickerDialog_End.show();
    }

}
