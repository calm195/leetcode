
import java.util.PriorityQueue;

/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-30 08:41:38
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-30 09:21:04
 * @Description: 
 * 
 * PriorityQueue pass
 * PriorityQueue + unreserve index  pass
 */
public class SeatManager {

    private final PriorityQueue<Integer> available;
    private int minSeatNumber;

    public SeatManager(int n){
        available = new PriorityQueue<>();
    }

    public int reserve(){
        return available.isEmpty() ? ++minSeatNumber : available.poll();
    }

    public void unreserve(int seatNumber){
        available.offer(seatNumber);
    }
}
