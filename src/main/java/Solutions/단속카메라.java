package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        for(int[] route : routes) {
            for(int r : route){
                System.out.print(r + " ");
            }
            System.out.println();
        }

        List<Integer> camera = new ArrayList<>();
        camera.add(routes[0][1]);
        for(int i = 0 ; i < routes.length ; i ++){
            int start = routes[i][0];
            int end = routes[i][1];
            int lastCamera = camera.get(camera.size()-1);
            if(start <= lastCamera && end >= lastCamera){
                continue;
            } else {
                camera.add(end);
            }
        }
        System.out.println(camera);
        System.out.println(camera.size());
    }
}
