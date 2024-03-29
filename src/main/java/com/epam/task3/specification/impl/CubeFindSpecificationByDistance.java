package com.epam.task3.specification.impl;

import com.epam.task3.action.point.CustomPointCalculation;
import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.specification.CubeFindSpecification;

import java.util.ArrayList;
import java.util.List;

public class CubeFindSpecificationByDistance implements CubeFindSpecification {//from point (0,0,0)
    double desiredDistance;

    public CubeFindSpecificationByDistance(double desiredDistance) {
        this.desiredDistance = desiredDistance;
    }

    @Override
    public boolean specified(Cube cube) {
        CustomPoint centerPointOfCube = cube.getCenterPoint();
        CustomPointCalculation customPointCalculation = new CustomPointCalculation();
        double halfOfSideLength = cube.getSideLength() / 2;
        List<CustomPoint> vertexPointList = new ArrayList<>();
        CustomPoint pointOfCube1 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, -1, -1);
        vertexPointList.add(pointOfCube1);

        CustomPoint pointOfCube2 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, -1, -1);
        vertexPointList.add(pointOfCube2);

        CustomPoint pointOfCube3 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, 1, -1);
        vertexPointList.add(pointOfCube3);

        CustomPoint pointOfCube4 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, 1, -1);
        vertexPointList.add(pointOfCube4);

        CustomPoint pointOfCube5 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, -1, 1);
        vertexPointList.add(pointOfCube5);

        CustomPoint pointOfCube6 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, -1, 1);
        vertexPointList.add(pointOfCube6);

        CustomPoint pointOfCube7 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                -1, 1, 1);
        vertexPointList.add(pointOfCube7);

        CustomPoint pointOfCube8 = customPointCalculation.findVertexPoint(centerPointOfCube, halfOfSideLength,
                1, 1, 1);
        vertexPointList.add(pointOfCube8);

        for (CustomPoint currentVertexPoint : vertexPointList) {
            if (isPointAtSuchDistance(currentVertexPoint)) return true;
        }
        return false;
    }

    private boolean isPointAtSuchDistance(CustomPoint point) { //from (0,0,0)
        double x = point.getX();
        double y = point.getY();
        double z = point.getZ();
        double distance = Math.sqrt(x * x + y * y + z * z);
        return distance <= desiredDistance;
    }
}
