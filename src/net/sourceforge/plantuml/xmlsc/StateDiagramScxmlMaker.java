/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 * 
 * Revision $Revision: 5079 $
 *
 */
package net.sourceforge.plantuml.xmlsc;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import net.sourceforge.plantuml.Log;
import net.sourceforge.plantuml.statediagram.StateDiagram;

public final class StateDiagramScxmlMaker {

	private final StateDiagram diagram;

	public StateDiagramScxmlMaker(StateDiagram diagram) throws IOException {
		this.diagram = diagram;
	}

	public void createFiles(OutputStream fos) throws IOException {
		try {
			final ScxmlStateDiagramStandard xmi;
			xmi = new ScxmlStateDiagramStandard(diagram);
			xmi.transformerXml(fos);
		} catch (ParserConfigurationException e) {
			Log.error(e.toString());
			e.printStackTrace();
			throw new IOException(e.toString());
		} catch (TransformerException e) {
			Log.error(e.toString());
			e.printStackTrace();
			throw new IOException(e.toString());
		}
	}

}