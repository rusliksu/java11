package anonymousInnerClass;

// В этой программе демонстрируется применение анонимных внутренних классов

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock=new TalkingClock();
        clock.start(1000, true);

        // Выполнять программу до тех пор, пока пользователь
        // не щелкнет на кнопке ОК
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

// Часы, выводящие время через регулярные промежутки
class TalkingClock
{
    /**
     * Запускает часы
     * @param interval Интервал между сообщениями (в миллисекундах)
     * @param beep Истинно, если часы должны издавать звуковой сигнал
     */
    public void start(int interval, boolean beep)
    {
        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone? the time is "
                                    + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t =new Timer(interval, listener);
        t.start();

    }
}
