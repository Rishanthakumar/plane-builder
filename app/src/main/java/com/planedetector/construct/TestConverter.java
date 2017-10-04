package com.planedetector.construct;

import android.annotation.TargetApi;
import android.os.Build;

import org.rajawali3d.math.vector.Vector3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.planedetector.construct.rendering.MeshTree;

public class TestConverter {


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void main(String[] args) {

        List<Vector3> points = new ArrayList<>();

        System.out.print("loading pointcloud ...");

        points.add(new Vector3(1, 2, 2.3));
        points.add(new Vector3(2, 1, 2.3));
        points.add(new Vector3(3, 5, 2.3));
        points.add(new Vector3(4, 2, 2.3));
        points.add(new Vector3(5, 2, 2.3));
        points.add(new Vector3(6, 1, 2.3));
        points.add(new Vector3(7, 5, 2.3));
        points.add(new Vector3(2, 2, 2.3));

        points.add(new Vector3(-1.5, -0.8, 2.5));
        points.add(new Vector3(-1.5, -0.8, 2.5));
        points.add(new Vector3(-1.5, -0.9, 2.5));
        points.add(new Vector3(-1.5, -0.9, 2.5));
        points.add(new Vector3(-1.4, -0.9, 2.6));
        points.add(new Vector3(-1.4, -0.9, 2.6));
        points.add(new Vector3(-1.5, -0.9, 2.7));
        points.add(new Vector3(-1.4, -0.9, 2.7));
        points.add(new Vector3(-1.4, -0.9, 2.6));
        points.add(new Vector3(-1.3, -0.9, 2.6));
        points.add(new Vector3(-1.3, -0.9, 2.6));
        points.add(new Vector3(-1.3, -0.9, 2.6));
        points.add(new Vector3(-1.3, -0.9, 2.6));
        points.add(new Vector3(-1.2, -0.9, 2.6));
        points.add(new Vector3(-1.2, -0.9, 2.6));
        points.add(new Vector3(-1.1, -0.9, 2.5));
        points.add(new Vector3(-1.1, -0.8, 2.5));
        points.add(new Vector3(-1.1, -0.8, 2.4));
        points.add(new Vector3(-1.0, -0.8, 2.4));
        points.add(new Vector3(-1.0, -0.8, 2.4));
        points.add(new Vector3(-1.0, -0.8, 2.4));
        points.add(new Vector3(-0.9, -0.8, 2.4));
        points.add(new Vector3(-0.9, -0.8, 2.4));
        points.add(new Vector3(-0.9, -0.8, 2.4));
        points.add(new Vector3(-0.9, -0.8, 2.4));
        points.add(new Vector3(-0.8, -0.8, 2.4));
        points.add(new Vector3(-0.8, -0.8, 2.4));
        points.add(new Vector3(-0.8, -0.8, 2.4));
        points.add(new Vector3(-0.8, -0.8, 2.4));
        points.add(new Vector3(-0.7, -0.8, 2.4));
        points.add(new Vector3(-0.7, -0.8, 2.4));
        points.add(new Vector3(-0.7, -0.8, 2.4));
        points.add(new Vector3(-0.6, -0.8, 2.4));
        points.add(new Vector3(-0.7, -0.8, 2.4));
        points.add(new Vector3(-0.7, -0.8, 2.4));

        points.add(new Vector3(-0.6, -0.8, 2.4));
        points.add(new Vector3(-0.6, -0.8, 2.4));

        System.out.println(" DONE - loaded " + points.size() + " vertices \n");
        MeshTree m = new MeshTree(new Vector3(-20, -20, -20), 40.0, 11, 4);
        System.out.println("Storing points into meshtree ...");

        m.putPoints(points);

        int storedPoints = m.getNewPointsCount();
        System.out.println(" DONE inserted " + storedPoints + " points \n Do polygon reconstruction ...");
        m.updateMesh();

        Stack<Vector3> polygons = new Stack<>();
        m.fillPolygons(polygons);


        System.out.println(" DONE got " + polygons.size() + " polygon vertices - \nGenerate PLY file ...");


        for (Vector3 vertex : polygons) {
            System.out.println(vertex.x + " " + vertex.y + " " + vertex.z);
        }

        System.out.println(" DONE");

    }
}
