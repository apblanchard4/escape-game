/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2016-2023 Gary F. Pollice
 *******************************************************************************/

package escape.builder;

import escape.PlayerInfo;
import escape.required.Coordinate.CoordinateType;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * An example of reading a game configuration file and storing the information in this
 * data object. Using this object, you can get the information needed to create your
 * game.
 * 
 * MODIFIABLE: YES
 * MOVEABLE: NO
 * REQUIRED: NO
 * 
 * @see EscapeGameBuilder#makeGameManager()
 */
@XmlRootElement
public class EscapeGameInitializer
{
	private CoordinateType coordinateType;
	
	// Board items
	private int xMax, yMax;
	private LocationInitializer[] locationInitializers;
	
	// Piece items
	private PieceTypeDescriptor[] pieceTypes;
	
	// Rule items
	private RuleDescriptor[] rules;

	//Game players
	private String[] players;
	private PlayerInfo[] playerInfo;


    
    public EscapeGameInitializer()
    {
        // Needed for JAXB
    }

    /**
     * @return the coordinateType
     */
    public CoordinateType getCoordinateType()
    {
        return coordinateType;
    }

    /**
     * @param coordinateType the coordinateType to set
     */
    public void setCoordinateType(CoordinateType coordinateType)
    {
        this.coordinateType = coordinateType;
    }

	/**
	 * @return the xMax
	 */
	public int getxMax()
	{
		return xMax;
	}

	/**
	 * @param xMax the xMax to set
	 */
	public void setxMax(int xMax)
	{
		this.xMax = xMax;
	}

	/**
	 * @return the yMax
	 */
	public int getyMax()
	{
		return yMax;
	}

	/**
	 * @param yMax the yMax to set
	 */
	public void setyMax(int yMax)
	{
		this.yMax = yMax;
	}

	/**
	 * @return the locationInitializers
	 */
	public LocationInitializer[] getLocationInitializers()
	{
		return locationInitializers;
	}

	/**
	 * @param locationInitializers the locationInitializers to set
	 */
	public void setLocationInitializers(LocationInitializer ... locationInitializers)
	{
		this.locationInitializers = locationInitializers;
	}

	/**
	 * @return the types
	 */
	public PieceTypeDescriptor[] getPieceTypes()
	{
		return pieceTypes;
	}

	/**
	 * @param types the types to set
	 */
	public void setPieceTypes(PieceTypeDescriptor ... types)
	{
		this.pieceTypes = types;
	}

	/**
	 * @return the rules
	 */
	public RuleDescriptor[] getRules()
	{
		return rules;
	}

	/**
	 * @param rules the rules to set
	 */
	public void setRules(RuleDescriptor[] rules)
	{
		this.rules = rules;
	}

	public void setPlayers(String[] players) {
		this.players=players;
	}
	public String[] getPlayers() {
		return this.players;
	}

	public void setPlayerInfo(String[] players) {
		setPlayers(players);
		PlayerInfo[] playersInfo = new PlayerInfo[2];
		for (int i=0;i<this.players.length; i++) {
			String playerName = players[i];
			playersInfo[i] = new PlayerInfo(playerName, getPiecesOfPlayer(playerName));
		}
		this.playerInfo=playersInfo;
	}

	public PlayerInfo[] getPlayersInfo() {
		return this.playerInfo;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "EscapeGameInitializer [xMax=" + xMax + ", yMax=" + yMax
		    + ", coordinateType=" + coordinateType + ", locationInitializers="
		    + Arrays.toString(locationInitializers) + ", types="
		    + Arrays.toString(pieceTypes) + "]";
	}

	public int getPiecesOfPlayer(String player) {
		int pieces = 0;
		for (LocationInitializer locationInitializer : this.locationInitializers) {
			if (locationInitializer.player != null) {
				if (locationInitializer.player.equals(player)) {
					pieces++;
				}
			}
		}
		return pieces;
	}
}
