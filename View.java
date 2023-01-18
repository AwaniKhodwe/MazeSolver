package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.*;

public class View extends JFrame
{

    //use of 2 D array to represent the maze(graph)
    //maze[row][col]
    //Values: 0 = not visited, 1 = wall(blocked), 2 = visited node, 9 = target node


    int[][] maze =
                        {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 4, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                                {1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 9, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    private final ArrayList<Integer> path = new ArrayList<Integer>();
    //now lets define start position at (1, 1) and define the target node as "9" at position (11, 8)
    //borders must be filled with "1" to avoid ArrayIndexOutOfBounds


    public View()
    {
        setTitle("Simple Maze Solver");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //using depth first, checking first and last tem of path list
        DepthFirst.searchPath(maze, 1, 1, path);
        System.out.println(path);
    }

    @Override
    public void paint(Graphics g)
    {

        super.paint(g);

        g.translate(50, 50);
        //lets draw the maze

        for(int row=0; row < maze.length; row++)
        {
            for(int col = 0; col < maze[0].length; col++)
            {
                Color color;
                switch(maze[row][col])
                {
                    case 1 : color = Color.BLACK; break;
                    case 4 : color = Color.RED; break;
                    case 9 : color = Color.YELLOW; break;
                    default : color = Color.WHITE; break;

                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }


        //drawing the path list
        for(int p = 0; p < path.size(); p+=2)
        {
            int pathX = path.get(p);
            int pathY = path.get(p + 1);
            g.setColor(Color.GREEN);
            g.fillRect(pathX * 30, pathY * 30, 30, 30);


        }
    }

    public static void main(String[] args)
    {


        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run()
            {
                View view = new View();
                view.setVisible(true);
            }

        });


    }

    //maze generation code till here
}


