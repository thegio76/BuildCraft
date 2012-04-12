/** 
 * Copyright (c) SpaceToad, 2011
 * http://www.mod-buildcraft.com
 * 
 * BuildCraft is distributed under the terms of the Minecraft Mod Public 
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package net.minecraft.src.buildcraft.core;

/**
 * This class is a comparable container for block positions.
 * TODO: should this be merged with position?
 */
public class BlockIndex implements Comparable<BlockIndex> {
	public int i;
	public int j;
	public int k;	

	/**
	 * Creates an index for a block located on i, j. k
	 */
	public BlockIndex (int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	/**
	 * Provides a deterministic and complete ordering of block positions.
	 */
	public int compareTo(BlockIndex o) {
		if (o.i < i) {
			return 1;
		} else if (o.i > i) {
			return -1;
		} else if (o.k < k) {
			return 1;
		} else if (o.k > k) {
			return -1;
		} else if (o.j < j) {
			return 1;
		} else if (o.j > j) {
			return -1;
		} else {
			return 0;
		}
	}
}