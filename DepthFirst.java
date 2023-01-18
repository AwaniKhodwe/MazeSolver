package com.company;
import java.util.List;

public class DepthFirst {

        //if path was found, this method will return true and the path list will be filled like this:
        //{xn, yn, ..., x2, y2, x1, y1}
        //so the order is inverted
        //x and y are the start searching position
        public static boolean searchPath(int [][] maze, int x, int y, List<Integer> path)
        {
            //checking if the target node was reached
            if(maze[y][x] == 9)
            {
                path.add(x);
                path.add(y);
                return true;

            }
            //when the current position (x, y) is
            // a not visited node (0), then let's
            // mark it as visited (2)

            if(maze[y][x] == 4)
            {

                System.out.println("RAT GOT CAUGHT!!!");

            }
            if(maze[y][x] == 0)
            {
                maze[y][x] = 2;

                //now lets visit all neighbour nodes recursively
                //if path was found, lets fill the path list

                int dx = -1;
                int dy = 0;

                if(searchPath(maze, x +dx, y + dy, path))
                {
                    path.add(x);
                    path.add(y);
                    return true;

                }

                dx = 1;
                dy = 0;

                if(searchPath(maze, x +dx, y + dy, path))
                {
                    path.add(x);
                    path.add(y);
                    return true;

                }

                dx = 0;
                dy = -1;

                if(searchPath(maze, x +dx, y + dy, path))
                {
                    path.add(x);
                    path.add(y);
                    return true;

                }

                dx = 0;
                dy = 1;

                if(searchPath(maze, x +dx, y + dy, path))
                {
                    path.add(x);
                    path.add(y);
                    return true;

                }
            }
            return false;

        }

}
