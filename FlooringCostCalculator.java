/*
 * PROJECT: Find cost to cover W x H Floor
 * DESCRIPTION: Calculate the total cost of tile it would take to cover a floor plan of width and length
 */

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlooringCostCalculator implements ActionListener
{
	public static void main(String[] args)
	{
		Scanner scanner= new Scanner(System.in);
		double width;
		double length;
		double cost;

		System.out.println("What is the width of the area you would like to tile?");
		width = scanner.nextDouble();

		System.out.println("What is the length of the area you would like to tile?");
		length = scanner.nextDouble();

		System.out.println("What is the cost per square unit of tile?");
		cost = scanner.nextDouble();

		// change to inches/ft/cm, etc later
		System.out.println("Your area of " + width*length + "will cost $" + cost*width*length + " to cover");

		scanner.close();
	}
}
