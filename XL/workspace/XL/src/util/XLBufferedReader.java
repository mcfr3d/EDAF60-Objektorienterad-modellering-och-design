package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Sheet;
import model.expr.Adress;


public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

 
    public void load(Sheet sheet){
        try {
            ArrayList<String> list = new ArrayList<String>();
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                Adress a = new Adress(string.substring(0, i));
                try{
                sheet.add(a, string.substring(i+1));
                }catch(XLException xl){
                    list.add(string);
                }
            }
			while(!list.isEmpty()){
                for(int j = 0; j < list.size(); j++){
				    String s = list.get(j);
                    int i = s.indexOf('=');
					try{
                        sheet.add(new Adress(s.substring(0, i)), s.substring(i+1));
						list.remove(j);
					}catch(XLException xl){
						
					}
                }
			}
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
