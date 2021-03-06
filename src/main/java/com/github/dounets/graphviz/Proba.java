package com.github.dounets.graphviz;

import java.io.File;

public class Proba
{
	public static void main(String[] args)
	{
		Proba p = new Proba();
		p.start();
		p.start2();
	}

	/**
	 * Construct a DOT graph in memory, convert it
	 * to image and store the image in the file system.
	 */
	private void start()
	{
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("A -> B;");
		gv.addln("A -> C;");
		gv.addln("A -> D;");
		gv.addln("B -> C;");
		gv.addln("F -> E;");
		gv.addln("A -> F;");
		gv.addln("C -> G;");
		gv.addln("G -> H;");
		gv.addln("G -> I;");
		gv.addln("A -> G;");
		gv.addln("A -> K;");
		gv.addln("A -> L;");
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		gv.increaseDpi();   // 106 dpi

		//		String type = "gif";
		//      String type = "dot";
		//      String type = "fig";    // open with xfig
		//      String type = "pdf";
		//      String type = "ps";
		//      String type = "svg";    // open with inkscape
		String type = "png";
		//      String type = "plain";
		
		String repesentationType= "dot";
		//		String repesentationType= "neato";
		//		String repesentationType= "fdp";
		//		String repesentationType= "sfdp";
		// 		String repesentationType= "twopi";
		// 		String repesentationType= "circo";
		
		File out = new File("D:/Project/ML/Graphiviz/graphviz-java-api/tmp/out"+gv.getImageDpi()+"."+ type);   // Windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}

	/**
	 * Read the DOT source from a file,
	 * convert to image and store the image in the file system.
	 */
	private void start2()
	{
		String dir = "D:/Project/ML/Graphiviz/graphviz-java-api";
		String input = dir + "/sample/file2.dot";
		GraphViz gv = new GraphViz();
		gv.readSource(input);
		System.out.println(gv.getDotSource());

		//String type = "gif";
		//    String type = "dot";
		//    String type = "fig";    // open with xfig
		//    String type = "pdf";
		//    String type = "ps";
		//    String type = "svg";    // open with inkscape
		    String type = "png";
		//      String type = "plain";
		
		
		String repesentationType= "dot";
		//		String repesentationType= "neato";
		//		String repesentationType= "fdp";
		//		String repesentationType= "sfdp";
		// 		String repesentationType= "twopi";
		//		String repesentationType= "circo";
		
		File out = new File("D:/Project/ML/Graphiviz/graphviz-java-api/tmp/simple." + type);
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}
}
