package winterPro;

public class TestCollection {
	String [][] test = new String [7][2];
	
	
	
	//test_1 ������ �� :break;
	//test_2 ������ �� :i
	//test_3 ������ �� :8
	//test_4 ������ �� :15
	//test_5 ������ �� :2
	//test_6 ������ �� :6
	//test_7 ������ �� :break;
	
	
	
	
	
	//=====================  ���� ======================//
		protected String test_1 = "���ߺ����� �������� ����ϴ� �����̴� ���� ��°���� ���;������� �� �κ��� �߸��Ǿ��ִ� �߸��� �κ��� ã�� �˸��� ��ɾ �����ÿ�.\n\n"
				+ "import java.util.*;\n"
				+ "public class RandomTest {\n"
				+ "	public static void main(String[] args) {\n\n"
				+ "	Random ran = new Random();\n"
				+ "	final int LENGTH = 20;\n"
				+ "	int[] arr = new int[LENGTH];\n"
				+ "	arr[0] = ran.nextInt(20);\n"
				+ "	for (int i = 1; i < LENGTH; i++) {\n"
				+ "		arr[i] = ran.nextInt(20);\n"
				+ "		for (int j = 0; j < i; j++) {\n"
				+ "			if (arr[j] == arr[i]) {\n"
				+ "				i--;\n"
				+ "				return;\n"
				+ "			}\n"
				+ "		}\n"
				+ "	}\n"
				+ "	for (int i = 0; i < LENGTH; i++) {\n"
				+ "		System.out.printf(\"%d \", arr[i]);\n"
				+ "		}\n"
				+ "	}\n"
				+ "}\n\n\n"
				+ "��°��\n\n "
				+ "14 12 10 6 2 1 0 4 13 5 19 11 18 9 15 17 8 7 3 16 " ;

		
		
		
		protected String test_2 = "�� for���� �̿��� �Ƕ�̵� ����� �����̴� �Ʒ� �ҽ��ڵ带 ���� Ʋ�� �κ��� ã�� �����Ǿ�� �ϴ� ���� �Է��Ͻÿ�  \n\n"
				+ "import java.util.Random;\n"
				+ "public class Star {\n"
				+ "   public static void main(String[] args) {\n\n"
				+ "	  for(int i = 1; i < 10; i++) {\n"
				+ "	     for(int j = 1; j<30; j++) {\n"
				+ "		 if(j>15-j && j<15+j) {\n"
				+ "		     System.out.print(\"*\");\n"
				+ "		 }else {\n"
				+ "		     System.out.print(\" \");\n"
				+ "		}\n"
				+ "	     }\n"
				+ "		System.out.println();\n"
				+ "	  }\n"
				+ "   }\n"
				+ "}\n"
				
				+ "��°��\n\n "
				+ "             *              \r\n" + 
				"             ***             \r\n" + 
				"            *****            \r\n" + 
				"           *******           \r\n" + 
				"          *********          \r\n" + 
				"         ***********         \r\n" + 
				"        *************        \r\n" + 
				"       ***************       \r\n" + 
				"      *****************  ";
				

		protected String test_3 = "�� ���� �ҽ��� ���� 4��° �ݺ��� �� 5��° �ڸ��� ���ڸ� �����ÿ�   \n\n"
				+ "public class ForLoopTest {\n"
				+ "   public static void main(String[] args) {\n\n"
				+ "	for (int i = 1; i <= 9; i++) {\n"
				+ "	   for (int j = i; j <= 9; j++) System.out.print(j);\n"
				+ "	      for (int j = 1; j <= i-1; j++) System.out.print(j);\n"
				+ "		    System.out.println();\n"
				+ "		    }\n"
				+ "	}\n"
				+ "}\n";

		protected String test_4 = "�� ���� �ҽ��� ��°���� �����Ͽ� 6��°���� 3��° �ڸ��� ���ڸ� �Է��Ͻÿ�.  \n\n"
				+ "public class ArrayTest {\n"
				+ "  public static void main(String args[])throws Exception{\n\n"
				+ "   int arry[][]=new int[5][5];\n"
				+ "   int rows=0;\n"
				+ "   int cols[]=new int[5];\n"
				+ "     for(int i=0;i<5;i++){\n"
				+ "      for(int j=0;j<5;j++){\n"
				+ "       arry[i][j] = j+1;\n"
				+ "      }\n"
				+ "    }\n\n"
				+ "     for(int i=0;i<5;i++){\n"
				+ "      for(int j=0;j<5;j++){\n"
				+ "       System.out.print(arry[i][j] + \" \");\n"
				+ "       rows += arry[i][j];\n"
				+ "       cols[i] += arry[i][i];\n"
				+ "      }\n"
				+ "       System.out.print(rows);\n"
				+ "       rows=0;\n"
				+ "       System.out.println();\n"
				+ "      }\n\n"
				+ "      for(int i=0;i<cols.length;i++){\n"
				+ "       System.out.print(cols[i]+\" \");\n"
				+ "      }\n\n"
				+ "     }\n"
				+ "   }";

		protected String test_5 = "�� ���� �ҽ��� ���� ��°�� 5��°�� 7��°�� ��µǴ� ���� ���� ������ ���ÿ�   \n\n"
				+ "(����)  7��° �ڸ��� �ش��ϴ� �˸��� ����� ���ÿ�.\n"
				+ "1.[56]     2.[179]     3.[212]     4.[141]     5.[154]     6.[053]     7.[115]\n\n\n"
				+ "public class ArrayTest { \n"
				+ "  public static void main(String args[])throws Exception{\n\n"
				+ "   int count = 15;\n"
				+ "   int total = count * count;\n"
				+ "   int arr[][] = new int[count][count];\n"
				+ "   int i = 0, Ystart = 0, Yend = count+1;\n"
				+ "   int j = -1, Xstart = -1, Xend = count+1;\n"
				+ "   int n = 0;\n\n"
				+ "   while (n <= total) {\n"
				+ "      Xend--;\n\n"
				+ "      for (j = j + 1; j < Xend; j++) {\n"
				+ "       arr[i][j] = ++n;\n"
				+ "      }\n\n"
				+ "      if(n ==total)\n"
				+ "         break;\n\n"
				+ "      j--; \n"
				+ "      Yend--;\n"
				+ "      for (i = i + 1; i < Yend; i++) { \n"
				+ "       arr[i][j] = ++n;\n"
				+ "      } \n\n"
				+ "      i--;\n"
				+ "      Xstart++;\n\n"
				+ "      if(n ==total)\n"
				+ "       break;\n\n"
				+ "      for (j = j - 1; j >= Xstart; j--) {\n"
				+ "       arr[i][j] = ++n;\n"
				+ "      }\n\n"
				+ "      j++;\n"
				+ "      Ystart++;\n\n"
				+ "      if(n ==total)\n"
				+ "         break;\n\n"
				+ "      for (i = i - 1; i >= Ystart; i--) { \n"
				+ "       arr[i][j] = ++n;\n"
				+ "      }\n\n"
				+ "      i++;\n\n"
				+ "      if(n < total)\n"
				+ "         continue;\n"
				+ "      else\n"
				+ "         break;\n"
				+ "      }\n\n"
				+ "      for (i = 0; i < count; i++) {\n"
				+ "        for (j = 0; j < count; j++) {\n"
				+ "          System.out.printf(\"[%03d]\", arr[i][j]);\n"
				+ "        }\n"
				+ "        System.out.println(\"\"); \n"
				+ "      } \n"
				+ "   }\n"
				+ "}";
				
							

		protected String test_6 = "�� ���� �ҽ��� ���� ��µǴ� ���� �ε����� ����ΰ�?   \n\n"
				+ "public class ArrayTest { \n"
				+ "  public static void main(String args[]){\n\n"
				+ "    int[] arr = { 35, 28, 67, 73, 25, 32, 12, 69, 97, 56, 14, 23, 45, 97, 48, 15 };\n\n"
				+ "    int i, min_val, min_idx;\n"
				+ "    min_val = arr[0];\n\n"
				+ "    min_idx = 0;\n"
				+ "    for (i = 1; i < arr.length; i++){\n"
				+ "      if (min_val > arr[i]){\n"
				+ "          min_val = arr[i];\n"
				+ "          min_idx = i;\n"
				+ "       }\n"
				+ "     }\n"
				+ "   }\n"
				+ "}\n";

		protected String test_7 = "public class Test_7 {\n" // ����  14
				+ "    int a = 10;\n"
				+ "    System.out.println(a+4);\n"
				+ "}";
		
		public TestCollection() {
			
			test[0][0] = test_1;
			test[1][0] = test_2;
			test[2][0] = test_3;
			test[3][0] = test_4;
			test[4][0] = test_5;
			test[5][0] = test_6;
			test[6][0] = test_7;
			
			test[0][1] = "break;";
			test[1][1] = "i";
			test[2][1] = "8";
			test[3][1] = "15";
			test[4][1] = "2";
			test[5][1] = "6";
			test[6][1] = "14";
		}
}
