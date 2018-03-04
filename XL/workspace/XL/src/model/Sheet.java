package model;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import model.expr.*;
import util.XLBufferedReader;
import util.XLException;

public class Sheet extends Observable implements Environment {
    private Map<Adress, Cell> map;

    public Sheet() {
        map = new HashMap<Adress, Cell>();
    }

    public double value(String adressName) throws XLException {
        Adress adress = new Adress(adressName);
        if (map.containsKey(adress)) {
            return map.get(adress).value();
        }
        throw new XLException("No value in referenced cell");
    }

    public void add(Adress adress, String value) throws XLException {
        if (adress.toString().equals(value)) {
            throw new XLException("Cell directly references self");
        } else if (value.isEmpty()) {
            map.remove(adress);
        } else if (map.containsKey(adress)) {
            map.get(adress).setValue(value);
        } else {
            map.put(adress, new Cell(value, this));
        }
        update(getSheet());
    }

    public String getFormula(Adress adress) {
        Cell temp = map.get(adress);
        if (temp != null) {
            return temp.toString();
        }
        return "";
    }

    public Set<Entry<Adress, Cell>> getSheet() {
        return map.entrySet();
    }

    // public Map<Adress, Cell> getMap() {
    // return map;
    // }

    public String stringInCell(Adress adress) {
        String s = "";
        if (map.containsKey(adress)) {
            s = s + map.get(adress).value();
        }
        return s;
    }

    public void clearAll() {
        map.clear();
        update(getSheet());
    }

    public void load(String path) throws IOException {
        XLBufferedReader xlbr = new XLBufferedReader(path);
        clearAll();
        xlbr.load(this);
        update(getSheet());
        xlbr.close();
    }

    public void update(Set<Entry<Adress, Cell>> m) {
        setChanged();
        notifyObservers(m);
    }

//    public void remove(Adress current) {
//        if (map.containsKey(current)) {
//            map.remove(current);
//            update(getSheet());
//        }
//    }

    public void clear(Adress a) {
        map.remove(a);
        update(getSheet());
    }
}
