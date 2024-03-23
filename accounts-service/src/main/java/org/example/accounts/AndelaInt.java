package org.example.accounts;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description of the class.
 * <p>
 *
 * @author meshack.karori on 9/6/2023.
 */

public class AndelaInt {
    public AndelaInt() {
    }

    public int addNum(int num) {
        int newNum = num + 6;
        System.out.println(newNum);
        return newNum;
    }
}
