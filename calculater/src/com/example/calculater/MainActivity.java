package com.example.calculater;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	//声明一些控件
    Button btn0=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btnBackspace=null;
    Button btnCE=null;
    Button btnC=null;
    Button btnAdd=null;
    Button btnSub=null;
    Button btnMul=null;
    Button btnDiv=null;
    Button btnEqu=null;
    TextView tvResult=null;
    //数据库相关按钮
    Button create_database = null;
    Button update_database = null;
    Button insert = null;
    Button update = null;
    Button query = null;
    Button delete = null;

    
  //声明两个参数。接收tvResult前后的值
    double num1=0,num2=0;
    double Result=0;//计算结果
    int op=0;//判断操作数，
    boolean isClickEqu=false;//判断是否按了“=”按钮
    int i=0;//数据库序号
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//从布局文件中获取控件，
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btnBackspace=(Button)findViewById(R.id.btnBackspace);
        btnCE=(Button)findViewById(R.id.btnCE);
        btnC=(Button)findViewById(R.id.btnC);
        btnEqu=(Button)findViewById(R.id.btnEqu);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        tvResult=(TextView)findViewById(R.id.tvResult);
        //添加监听\
        btnBackspace.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
        //数据库相关按钮监听
        create_database = (Button)findViewById(R.id.create_database);
        create_database.setOnClickListener(new CreateDatabaseOnClickListener());
        update_database = (Button)findViewById(R.id.update_database);
        update_database.setOnClickListener(new UpdateDatabaseOnClickListener());
        insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new InsertOnClickListener());
        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new UpdateOnClickListener());
        query = (Button)findViewById(R.id.query);
        query.setOnClickListener(new QueryOnClickListener());
        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new DeleteOnClickListener());

	}
	@Override
    public void onClick(View v) {
        switch (v.getId()) {
        //btnBackspace和CE--------------------
        case R.id.btnBackspace:
            String myStr=tvResult.getText().toString();
            try {
                tvResult.setText(myStr.substring(0, myStr.length()-1));
            } catch (Exception e) {
                tvResult.setText("");
            }

            break;
        case R.id.btnCE:
            tvResult.setText(null);
            break;

            //btn0--9---------------------------
        case R.id.btn0:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString=tvResult.getText().toString();
            myString+="0";
            tvResult.setText(myString);
            break;
        case R.id.btn1:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString1=tvResult.getText().toString();
            myString1+="1";
            tvResult.setText(myString1);
            break;
        case R.id.btn2:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString2=tvResult.getText().toString();
            myString2+="2";
            tvResult.setText(myString2);
            break;
        case R.id.btn3:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString3=tvResult.getText().toString();
            myString3+="3";
            tvResult.setText(myString3);
            break;
        case R.id.btn4:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString4=tvResult.getText().toString();
            myString4+="4";
            tvResult.setText(myString4);
            break;
        case R.id.btn5:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString5=tvResult.getText().toString();
            myString5+="5";
            tvResult.setText(myString5);
            break;
        case R.id.btn6:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString6=tvResult.getText().toString();
            myString6+="6";
            tvResult.setText(myString6);
            break;
        case R.id.btn7:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString7=tvResult.getText().toString();
            myString7+="7";
            tvResult.setText(myString7);
            break;
        case R.id.btn8:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString8=tvResult.getText().toString();
            myString8+="8";
            tvResult.setText(myString8);
            break;
        case R.id.btn9:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString9=tvResult.getText().toString();
            myString9+="9";
            tvResult.setText(myString9);
            break;

            //btn+-*/=--------------------------------
        case R.id.btnAdd:            
            String myStringAdd=tvResult.getText().toString();
            if(myStringAdd.equals(null))
            {
                return;
            }
            num1=Double.valueOf(myStringAdd);
            tvResult.setText(null);
            op=1;
            isClickEqu=false;
            break;

        case R.id.btnSub:
            String myStringSub=tvResult.getText().toString();
            if(myStringSub.equals(null))
            {
                return;
            }
            num1=Double.valueOf(myStringSub);
            tvResult.setText(null);
            op=2;
            isClickEqu=false;
            break;
        case R.id.btnMul:
            String myStringMul=tvResult.getText().toString();
            if(myStringMul.equals(null))
            {
                return;
            }
            num1=Double.valueOf(myStringMul);
            tvResult.setText(null);
            op=3;
            isClickEqu=false;
            break;
        case R.id.btnDiv:
            String myStringDiv=tvResult.getText().toString();
            if(myStringDiv.equals(null))
            {
                return;
            }
            num1=Double.valueOf(myStringDiv);
            tvResult.setText(null);
            op=4;
            isClickEqu=false;
            break;
        case R.id.btnEqu:
            String myStringEqu=tvResult.getText().toString();
            if(myStringEqu.equals(null))
            {
                return;
            }
            num2=Double.valueOf(myStringEqu);
            tvResult.setText(null);
            switch (op) {
            case 0:
                Result=num2;
                break;
            case 1:
                Result=num1+num2;
                break;
            case 2:
                Result=num1-num2;
                break;
            case 3:
                Result=num1*num2;
                break;
            case 4:
                Result=num1/num2;
                break;
            default:
                Result=0;
                break;
            }
            tvResult.setText(String.valueOf(Result));
            isClickEqu=true;
            break;

        default:
            break;
        }
    } 
	//创建数据库
	public class CreateDatabaseOnClickListener implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            //创建一个DatabaseHelper类的对象，该类是单独一个java文件,这里采用2个参数的构造函数，建立的数据
            //库的名字为tornadomeet.db
            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
            //只有调用getReadableDatabase()或者getWriteableDatabase()函数后才能返回一个SQLiteDatabase对象
            SQLiteDatabase db = database_helper.getReadableDatabase();
        }                
    }
	//更新数据库
	 public class UpdateDatabaseOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db", 2);
	            SQLiteDatabase db = database_helper.getReadableDatabase();
	        }        
	    }
	 //插入数据
	 public class InsertOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // 生成contentvallues对象，该对象用来存数据的
	            ContentValues values = new ContentValues();
	            values.put("id", i);
	            values.put("name", Result);
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();//这里是获得可写的数据库
	            db.insert("user1", null, values);
	            System.out.println("插入数据");
	            i++;
	        }       
	    }
	 //更新数据
	 public class UpdateOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            ContentValues values = new ContentValues();
	            values.put("name", "liuwenjin");
	            //参数1为表名，参数2为更新后的值，参数3表示满足条件的列名称，参数4为该列名下的值
	            db.update("user1", values, "id=?", new String[]{"1"});
	            System.out.println("更新数据");
	        }        
	    }
	 //查询数据
	 public class QueryOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            //查询的语法，参数1为表名；参数2为表中的列名；参数3为要查询的列名；参数时为对应列的值；该函数返回的是一个游标
	            Cursor cursor = db.query("user1", new String[]{"id", "name"}, "id=?", new String[]{"1"},  null, null, null);
	            //遍历每一个记录
	            while(cursor.moveToNext()) {
	                String name = cursor.getString(cursor.getColumnIndex("name"));//返回列名为name的值
	                System.out.println("query---->" + name);
	            }
	        }       
	    }
	 //删除数据
	 public class DeleteOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            //直接删除名为liuwenjin对应的那条记录
	            db.delete("user1", "name=?" ,new String[]{"liuwenjin"});
	            System.out.println("删除数据");
	        }
	 }

}
