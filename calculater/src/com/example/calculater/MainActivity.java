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
	//����һЩ�ؼ�
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
    //���ݿ���ذ�ť
    Button create_database = null;
    Button update_database = null;
    Button insert = null;
    Button update = null;
    Button query = null;
    Button delete = null;

    
  //������������������tvResultǰ���ֵ
    double num1=0,num2=0;
    double Result=0;//������
    int op=0;//�жϲ�������
    boolean isClickEqu=false;//�ж��Ƿ��ˡ�=����ť
    int i=0;//���ݿ����
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//�Ӳ����ļ��л�ȡ�ؼ���
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
        //��Ӽ���\
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
        //���ݿ���ذ�ť����
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
        //btnBackspace��CE--------------------
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
	//�������ݿ�
	public class CreateDatabaseOnClickListener implements OnClickListener{

        public void onClick(View v) {
            // TODO Auto-generated method stub
            //����һ��DatabaseHelper��Ķ��󣬸����ǵ���һ��java�ļ�,�������2�������Ĺ��캯��������������
            //�������Ϊtornadomeet.db
            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
            //ֻ�е���getReadableDatabase()����getWriteableDatabase()��������ܷ���һ��SQLiteDatabase����
            SQLiteDatabase db = database_helper.getReadableDatabase();
        }                
    }
	//�������ݿ�
	 public class UpdateDatabaseOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db", 2);
	            SQLiteDatabase db = database_helper.getReadableDatabase();
	        }        
	    }
	 //��������
	 public class InsertOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // ����contentvallues���󣬸ö������������ݵ�
	            ContentValues values = new ContentValues();
	            values.put("id", i);
	            values.put("name", Result);
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();//�����ǻ�ÿ�д�����ݿ�
	            db.insert("user1", null, values);
	            System.out.println("��������");
	            i++;
	        }       
	    }
	 //��������
	 public class UpdateOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            ContentValues values = new ContentValues();
	            values.put("name", "liuwenjin");
	            //����1Ϊ����������2Ϊ���º��ֵ������3��ʾ���������������ƣ�����4Ϊ�������µ�ֵ
	            db.update("user1", values, "id=?", new String[]{"1"});
	            System.out.println("��������");
	        }        
	    }
	 //��ѯ����
	 public class QueryOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            //��ѯ���﷨������1Ϊ����������2Ϊ���е�����������3ΪҪ��ѯ������������ʱΪ��Ӧ�е�ֵ���ú������ص���һ���α�
	            Cursor cursor = db.query("user1", new String[]{"id", "name"}, "id=?", new String[]{"1"},  null, null, null);
	            //����ÿһ����¼
	            while(cursor.moveToNext()) {
	                String name = cursor.getString(cursor.getColumnIndex("name"));//��������Ϊname��ֵ
	                System.out.println("query---->" + name);
	            }
	        }       
	    }
	 //ɾ������
	 public class DeleteOnClickListener implements OnClickListener{

	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	            DatabaseHelper database_helper = new DatabaseHelper(MainActivity.this, "result.db");
	            SQLiteDatabase db = database_helper.getWritableDatabase();
	            //ֱ��ɾ����Ϊliuwenjin��Ӧ��������¼
	            db.delete("user1", "name=?" ,new String[]{"liuwenjin"});
	            System.out.println("ɾ������");
	        }
	 }

}
