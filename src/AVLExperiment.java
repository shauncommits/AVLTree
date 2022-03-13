import java.util.Scanner;
import java.io.*;


public class AVLExperiment{
     
     
    int num = 0;  
    AVLTree<Vaccine> bt = new AVLTree<Vaccine> ();
    
    public AVLExperiment(){
    }
    FileWriter wrt = null;
    public void permutation(String[] array,int size,int permu)
    {
        
        if(permu<9919){
               
        for(int i = 0; i<permu; i++)
        {
            if(size%2 == 1)
            {
                String temp = array[0];
                array[0] = array[size-1];
                array[size-1] = temp;
            }
            else
            {
                String temp;
                temp = array[i];
                array[i] = array[size-1];
                array[size-1] = temp;
            }
            size = size-1;
        }
        }
        else{
            for(int i = 0; i<9920; i++)
            {
            if(size%2 == 1)
            {
                String temp = array[0];
                array[0] = array[size-1];
                array[size-1] = temp;
            }
            else
            {
                String temp;
                temp = array[i];
                array[i] = array[size-1];
                array[size-1] = temp;
            }
            size = size - 1;
        }

            permu = permu-9919;
            permutation(array,size,permu);
        }
    }



    public static void main(String[] args)
    {
        AVLTree<Vaccine> avl = new AVLTree<Vaccine> ();  
    
        AVLExperiment exp = new AVLExperiment();
        String[] arr = new String[9919];
        
        int count = 0;
        int permutations = 1;
        try{
             permutations = Integer.parseInt(args[0]);
            
            try{
                BufferedReader read = new BufferedReader(new FileReader("data/vaccinations.csv"));
                String line = "";
                while((line = read.readLine())!=null)
                {
                     arr[count] = line;  
                     count++;   
                }
                File newFile = new File("/home/shaun/Assignment2/data/newFile.txt");
                newFile.createNewFile();

                
                
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File does not exist!");
                System.exit(0);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            System.exit(0);
        } 
        String[] copy = new String[9919];
        
        exp.permutation(arr,9919,permutations);
        FileWriter wrt2 = null;
        FileWriter ins = null;
        int numb = 0;
            try{
                File search = new File("/home/shaun/Assignment2/data/searching_"+permutations);
                search.createNewFile();
                File insert = new File("/home/shaun/Assignment2/data/inserting_"+permutations);
                insert.createNewFile();

                wrt2 = new FileWriter("/home/shaun/Assignment2/data/searching_"+permutations);
                ins = new FileWriter("/home/shaun/Assignment2/data/inserting_"+permutations);
                for(int i =0;i<9919;i++){
                    avl.insert(new Vaccine(arr[i]));
                    ins.write(avl.insertOpCount+"\n");
                    avl.insertOpCount = 0;
                    numb++;
                    }
                ins.close();
                for(int i =0;i<9919;i++){
                    avl.find(new Vaccine(arr[i]));
                    wrt2.write(avl.opCount+"\n");
                    avl.opCount = 0;
                    }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file does not exist!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
       
       try{
          wrt2.close();}catch(IOException e){e.printStackTrace();}
    }

}