import java.lang.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//<applet code="AppletDisplay1"width=1400 height=600></applet>
public class AppletDisplay1 extends Applet implements ActionListener {
	int days1[]={31,28,31,30,31,30,31,31,30,31,30,31};
	String yr,mth,wkd,str4="Invalid Input";
	Button b;
	TextField yr1,mth1,wkd1;
	Label l1,l2,l3;
	Font f=new Font("Arial",Font.BOLD,20);
	final int startColValue = 150;
	String[] weekdays = {"Sunday","Monday","Tuesday","Wednesday",
						"Thursday","Friday","Saturday"};
	String[] wkdays={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	String[] months={"january","february","march","april","may","june","july",
						"august","september","october","november","december"};
;
	
        public void init(){
        setLayout(new BorderLayout());
	Panel p=new Panel();
	Panel p1=new Panel();
	l1=new Label("Year:");
	yr1=new TextField("",30);
	l2=new Label("Month:");
	mth1=new TextField("",30);
	l3=new Label("Weekday:");
	wkd1=new TextField("",30);
	b=new Button("OK");
	l1.setFont(f);
	l2.setFont(f);
	l3.setFont(f);
	yr1.setFont(f);
	mth1.setFont(f);
	wkd1.setFont(f);
	p.add(l1);
	p.add(yr1);
	p.add(l2);
	p.add(mth1);
	p.add(l3);
	p.add(wkd1);
	add(p,BorderLayout.NORTH);
	p1.add(b);
	add(p1,BorderLayout.SOUTH);
	b.addActionListener(this);}

	public void actionPerformed(ActionEvent e){
	if(e.getSource()==b)
	{
	yr=yr1.getText();
	mth=mth1.getText();
	wkd=wkd1.getText();}	
	repaint();           
        }

        public void stop(){}

        public void paint(Graphics g){

        try{			
            int count=13,flag=0;
	    int t=Integer.parseInt(yr);
            int weekdayNumber = 8;
            int startCol = startColValue; 
            int incrFactor =70;
            
	    for(int i=0;i<weekdays.length;i++){
            	if(weekdays[i].equalsIgnoreCase(wkd))
            		weekdayNumber = i;
            }
	    for(int i=0;i<months.length;i++){
		if(months[i].equalsIgnoreCase(mth))
			count=i;}
		if(count==13||weekdayNumber==8)
			flag=1;
	    if(flag==1){flag=0;
		g.drawString(str4,150,150);}
	    else{
		g.drawString(mth.toUpperCase(), 150, 150);
            g.drawString(yr, 250, 150);
	    for(int i=0;i<weekdays.length;i++){
		g.drawString(wkdays[i],startCol,180);
            	startCol+=incrFactor;}
	    
            startCol = startColValue;
            int noOfDays = 31; 
            
            int initVal = 0;
            int colValue = startCol + (weekdayNumber * incrFactor);
            int rowValue = 200;
       	    if(count==0||count==2||count==4||count==6||count==7||count==9||count==11){
	    noOfDays=31;
            while(initVal<noOfDays){
            	if(colValue>570){
            		rowValue+=incrFactor; 
            		colValue = 150;
            	}
            	g.drawString((++initVal)+"", colValue, rowValue);
            	colValue+=incrFactor;}}
	    if(count==3||count==5||count==8||count==10){
	    noOfDays=30;
            while(initVal<noOfDays){
            	if(colValue>570){
            		rowValue+=incrFactor;
            		colValue = 150;
            	}
            	g.drawString((++initVal)+"", colValue, rowValue);
            	colValue+=incrFactor;}}
	    if(count==1){
		if(t%4==0)
		 noOfDays=29;
		else
		 noOfDays=28;
		while(initVal<noOfDays){
            	if(colValue>570){
            		rowValue+=incrFactor; 
            		colValue = 150;
            	}
            	g.drawString((++initVal)+"", colValue, rowValue);
            	colValue+=incrFactor;}
		  }
		}
	    }
	catch(Exception e){}
            }
        }
	