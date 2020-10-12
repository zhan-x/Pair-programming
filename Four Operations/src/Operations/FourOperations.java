package Operations ;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile; 
public class FourOperations{
	private static Random random = new Random();
	public static int range;
	//p1Ϊ������ӣ�q1Ϊ�����ĸ���Է�������Լ������
	//p2Ϊ�������ӣ�q2Ϊ������ĸ
	public static String ReductionOfFraction(int p1, int q1) {
		int temp = 1,p2,q2,i;//**��ʼֵ
		for (i = p1; i >= 1; i--) {
			if (p1 % i == 0 && q1 % i == 0) {
				temp = i;
				break;
			}
		}
		p2 = p1 / temp;// ����
		q2 = q1 / temp;// ��ĸ
		if (p2 == 0) {
			return "0";
		}
		if(q2==1) return p2+"";
		else  return expression(p2,q2);
		
	}
	//p1Ϊ������ӣ�q1Ϊ�����ĸ��mΪ�������������֣�nΪ���������Ӳ���
	//�ж������Ƿ�Ϊ�ٷ���������Ǽٷ�����Ϊ������
	public static String expression(int p1,int q1) {
		if(p1>=q1) {
			int m,n;
			m=p1/q1;
			//int d;
			n=p1%q1; 
			if(n==0){
				return m+"";
			}
			return m+"'"+n+"/"+q1;//** 
		}
		return p1+"/"+q1;
	}

	static long start=System.currentTimeMillis(); //��ȡ��ʼʱ��
	 
    //Ҫ��ĳ���򷽷�
 
	
public static void main(String[] args){ 
	Scanner scan= new Scanner(System.in);//Scanner ������ȡ�û�������
	System.out.println("�붨�������������");
	int range=scan.nextInt();//** 
    System.out.println("�붨��������ʽ�ĸ�����");
    int num=scan.nextInt();
  //  int [] rightcount;
    //int [] wrongcount; 
    int rightcount[]=new int[num+2];
    int wrongcount[] =new int[num+2];
 	int rightnum=0;
	int wrongnum=0;
	String[] results=new String[num];
	//int i;
	int numerator,denominator,i;
     for( i=0;i<num;i++){ 
        String subject[]=new String[2];//�������ɵ���Ŀ
        int p1= (int) (random.nextInt(range));//һ������
    	int q1= (int) (random.nextInt(range));//һ����ĸ
    	int p2= (int) (random.nextInt(range));//��һ������
    	int q2= (int) (random.nextInt(range));//��һ����ĸ
		int mark;//�����
		//a=p1,b=q1,c=p2,d=q2
    	mark= (int) (random.nextInt(4));//�������0~3��0��ʾ�ӷ���1��ʾ������2��ʾ�˷���3��ʾ����
		if(q1!=0&&q2!=0) {//Ҫ���ĸ��Ϊ0
		//markΪ0�����мӷ�����
		if(mark==0) {
    		numerator=p1*q2+q1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'+'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
    		results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ1�����м������㣬�������ķ���Ϊ��
		if(mark==1&&p1*q2-q1*p2>=0) {
    		numerator=p1*q2-q1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'-'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ1�����м������㣬�������ķ���Ϊ��
		if(mark==1&&p1*q2-q1*p2<0) {
    		numerator=q1*p2-p1*q2;
    		denominator=q1*q2;
    		subject[0]=expression(p2,q2)+' '+'-'+' '+expression(p1,q1)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ2�����г˷�����
    	if(mark==2) {
    		numerator=p1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ3�����г������㣬�ҳ������Ӳ�Ϊ0
    	if(mark==3&&p2!=0) {
    		numerator=p1*q2;
    		denominator=q1*p2;
    		subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ3�����г������㣬�ҳ�������Ϊ0**
    	if(mark==3&&p2==0) {
    		//break;
    		p2=1;
    		numerator=p1*q2;
    		denominator=q1*p2;
    		subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
    		results[i]=ReductionOfFraction(numerator, denominator);}
    	
    	}
    	else {//��ĸ������һ��Ϊ0ʱ������ֻ������ʽ������ʽ��ͬʱ������
			q1=1; q2=1;
		//markΪ0�����мӷ�����
		if(mark==0) {
			numerator=p1*q2+q1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'+'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ1�����м������㣬�������ķ���Ϊ��
		if(mark==1&&p1*q2-q1*p2>=0) {
			numerator=p1*q2-q1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'-'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ1�����м������㣬�������ķ���Ϊ��
		if(mark==1&&p1*q2-q1*p2<0) {
			numerator=q1*p2-p1*q2;
			denominator=q1*q2;
			subject[0]=expression(p2,q2)+' '+'-'+' '+expression(p1,q1)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ2�����г˷�����
		if(mark==2) {
			numerator=p1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ3�����г������㣬�ҳ������Ӳ�Ϊ0
		if(mark==3&&p2!=0) {
			numerator=p1*q2;
			denominator=q1*p2;
			subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//markΪ3�����г������㣬�ҳ�������Ϊ0**
		if(mark==3&&p2==0) {
			//break;
			p2=1;
			numerator=p1*q2;
			denominator=q1*p2;
			subject[0]=expression(p1,q1)+' '+'��'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}		
		}   
	//��Ŀ����
	FileWriter filewriter = null;//FileWriter�ఴ�ַ�������д������
    try {
        File file=new File("C:\\Users\\98577\\Desktop\\Exersies.txt");//��Ŀд��
        filewriter = new FileWriter(file, true);
    } catch (IOException e) {
		e.printStackTrace();}
	if(subject[0]!=null) {
    PrintWriter printwriter = new PrintWriter(filewriter);
    printwriter.println(i+1+"��"+subject[0]);
    printwriter.flush();
    try {
        filewriter.flush();
        printwriter.close();
        filewriter.close();
    } catch (IOException e) {
    	e.printStackTrace();
	}}
	//������
	FileWriter fileanswer = null;
    try {
            File file=new File("C:\\Users\\98577\\Desktop\\Answer.txt");//��д��
            fileanswer = new FileWriter(file, true);
        } catch (IOException e) {
        	e.printStackTrace();
		}
	if(subject[0]!=null) {
        PrintWriter printanswer = new PrintWriter(fileanswer);
        printanswer.println(i+1+"��"+results[i]);
        printanswer.flush();
        try {
            fileanswer.flush();
            printanswer.close();
            fileanswer.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }}
	}
    //����ҳ�淴��
     System.out.println("����your_answers.txt�������Ĵ𰸺�����'OK'��");
     Scanner scan1=new Scanner(System.in);
     String submit=scan1.nextLine();
	    if(submit.equals("OK")){
	 String array[]=new String[num];
    try
		{   int k=0;
		    
			FileReader fileread = new FileReader("C:\\Users\\98577\\Desktop\\Your_answers.txt");
			BufferedReader bufferedread = new BufferedReader(fileread);
			String s ;
			while((s = bufferedread.readLine())!=null) {//��ȡ����Ĵ�
				array[k]=s;	k++;
				}bufferedread.close();
				fileread.close();		
			}catch(IOException e){
				System.out.println("ָ���ļ�������");
			}
	
    for(int j=0;j<num;j++){
     	if(array[j].equals(results[j])) {//��֤�𰸣�ͳ����ȷ�ʹ���ĸ���
     		
     		rightcount[j]=j+1;
     		rightnum++;
     	}
     	else {
     		
     		wrongcount[j]=j+1;
     		wrongnum++;
     	}
	 }
	//
    FileWriter filegrade = null;
    try {
        //������ȷ�������Ŀ����Ϣ
            File file=new File("C:\\Users\\98577\\Desktop\\Grade.txt");
            filegrade = new FileWriter(file, true);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        PrintWriter printgrade = new PrintWriter(filegrade);
        printgrade.println(" ");
        printgrade.print("Correct:"+rightnum+"(");
       int max1=0;
       for (int j = 0; j <=num; j++) {
    	   if(rightcount[j] != 0) {
      		// printgrade.print(rightcount[j]+',');
    		   max1=j;
               }}
       for (int s = 0; s<=num; s++) {
        	   if(rightcount[s] != 0) {
          		printgrade.print(rightcount[s]);
          		if(s!=max1) {printgrade.print(',');}
       } }
        
      
        
        printgrade.println(")");
        printgrade.print("Wrong:"+wrongnum+"(");
        int max2=0;
        for (int j = 0; j <=num; j++) {
     	   if(wrongcount[j] != 0) {
     		   max2=j;
                }}
        for (int s = 0; s<=num; s++) {
         	   if(wrongcount[s] != 0) {
           		printgrade.print(wrongcount[s]);
           		if(s!=max2) {printgrade.print(',');}
        } }
        
        printgrade.print(")");
        printgrade.flush();
        try {
            filegrade.flush();
            printgrade.close();
            filegrade.close();
        } catch (IOException e) {
        	e.printStackTrace();
		}}
		System.out.println("�𰸶Ա�����ɣ�����Grade.txt�鿴�𰸶Դ�");
		long end=System.currentTimeMillis(); //��ȡ����ʱ��

		System.out.println("��������ʱ�䣺 "+(end-start)+"ms");	
}
//Ҫ��ĳ���򷽷�

}
