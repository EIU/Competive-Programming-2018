import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int theNumberOfShop=reader.nextInt();
        int theNumberOfProduct=reader.nextInt();
        int averageDistance=0;
        int []products= new int[theNumberOfShop];
        int []distances= new int[theNumberOfShop];
        int temp=0,acc=0,i,j;
        int theNumberOfTripsLeft=0,theNumberOfTripsRight=0,theNumberOfDistancesLeft=0,theNumberOfDistancesRight=0;
        for( i=0;i<theNumberOfShop;i++){
            int tempdistance=reader.nextInt();
            int tempproducts=reader.nextInt();
            averageDistance+=tempdistance;
            products[i]=tempproducts;
            distances[i]=tempdistance;
        }
        averageDistance/=theNumberOfShop;
        for( j=0;j<theNumberOfShop;j++){
            if(distances[j]<averageDistance){
                temp=products[j]/theNumberOfProduct;
                products[j]%=theNumberOfProduct;
                theNumberOfTripsLeft+=temp;
                theNumberOfDistancesLeft+=(averageDistance-distances[j])*temp;
                acc++;
            }else{
                temp=products[j]/theNumberOfProduct;
                products[j]%=theNumberOfProduct;
                theNumberOfTripsRight+=temp;
                theNumberOfDistancesRight+=(distances[j]-averageDistance)*temp;
            }
        }
        for(i=acc-1;i>=0;i--){
            if(i>0){
                if(products[i]+products[i-1]>=theNumberOfProduct){
                    theNumberOfDistancesLeft+=averageDistance-distances[i-1];
                    theNumberOfTripsLeft+=1;
                   products[i-1]+=products[i];
                   products[i-1]-=theNumberOfProduct;
                }else{
                    products[i-1]+=products[i];
                }
            }else{
                if(products[i]%theNumberOfProduct==0){
                    theNumberOfDistancesLeft+=averageDistance-distances[i];
                    theNumberOfTripsLeft+=1;
                }else{
                    theNumberOfDistancesLeft+=averageDistance-distances[i]+1;
                    theNumberOfTripsLeft+=1;
                }
            }
        }
        
    }
    public class hacknao{
        private int distances;
        private int products;
        
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
