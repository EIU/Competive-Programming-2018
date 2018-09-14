import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//BAI1
class Main {

	static class Student {
		public String name;
		String irn;
		public long avgGrade;
		public long STC;

		public Student(String irn, String name, long avgGrade, long STC) {
			this.name = name;
			this.irn = irn;
			this.avgGrade = avgGrade;
			this.STC = STC;

		}
	}

	public static long countSum(long[] grade) {
		int sum = 0;
		for (int i = 0; i < grade.length; i++) {
			sum += grade[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfStudent = reader.nextInt();
		int numberOfTerm = reader.nextInt();
		Student[] students = new Student[numberOfStudent];
		List<Student> List = new ArrayList<Student>();
		for (int i = 0; i < numberOfStudent; i++) {
			String irn = reader.next();
			String name = reader.next();
			int numerOfSubject = reader.nextInt();
			long[] grade = new long[numerOfSubject];
			long[] Grade = new long[numerOfSubject];
			long[] avg = new long[numberOfStudent];
			long avgGrade = 0;
			long count = 0;

			for (int j = 0; j < numerOfSubject; j++) {
				grade[j] = reader.nextLong();
				if (grade[j] >= 50) {
					count++;
					Grade[j] = grade[j];
				}
			}
			if (countSum(Grade) != 0) {
				avgGrade = countSum(Grade) / count;
			} else {
				avgGrade = 0;
			}
			if (count >= Math.round(numberOfTerm / 4)) {
				students[i] = new Student(irn, name, avgGrade, (count * 4));
				List.add(students[i]);
			}
		}
		List.sort((Student sv1, Student sv2) -> {
			int a = (int) (sv2.avgGrade - sv1.avgGrade);
			int b = (sv1.irn.compareTo(sv2.irn));
			int c=(int) (sv2.STC - sv1.STC);
			if (a != 0)
				return a;
			if(c==0)
			return (int) (sv2.STC - sv1.STC);
		});
		for (int i = 0; i < List.size(); i++) {
			System.out.println(
					List.get(i).irn + " " + List.get(i).name + " " + List.get(i).avgGrade + " " + List.get(i).STC);
		}
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
