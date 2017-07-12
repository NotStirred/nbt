/*
 * This file is part of nbt, licensed under the MIT License.
 *
 * Copyright (c) 2017 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

/**
 * A list tag.
 */
public final class ListTag extends Tag {

  /**
   * The list of tags.
   */
  private final List<Tag> tags = new ArrayList<>();
  /**
   * The type of this list.
   */
  @Nonnull private TagType type;

  public ListTag() {
    this(TagType.END);
  }

  public ListTag(@Nonnull final TagType type) {
    this.type = type;
  }

  /**
   * Gets the type of this list.
   *
   * @return the type
   */
  @Nonnull
  public TagType listType() {
    return this.type;
  }

  /**
   * Gets a tag.
   *
   * @param index the index
   * @return the tag
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  @Nonnull
  public Tag get(@Nonnegative final int index) {
    return this.tags.get(index);
  }

  /**
   * Gets a byte.
   *
   * @param index the index
   * @return the byte value, or {@code 0}
   */
  public byte getByte(@Nonnegative final int index) {
    return this.getByte(index, (byte) 0);
  }

  /**
   * Gets a byte.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the byte value, or {@code defaultValue}
   */
  public byte getByte(@Nonnegative final int index, final byte defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).byteValue();
    }
    return defaultValue;
  }

  /**
   * Gets a short.
   *
   * @param index the index
   * @return the short value, or {@code 0}
   */
  public short getShort(@Nonnegative final int index) {
    return this.getShort(index, (short) 0);
  }

  /**
   * Gets a short.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the short value, or {@code defaultValue}
   */
  public short getShort(@Nonnegative final int index, final short defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).shortValue();
    }
    return defaultValue;
  }

  /**
   * Gets an int.
   *
   * @param index the index
   * @return the int value, or {@code 0}
   */
  public int getInt(@Nonnegative final int index) {
    return this.getInt(index, 0);
  }

  /**
   * Gets an int.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the int value, or {@code defaultValue}
   */
  public int getInt(@Nonnegative final int index, final int defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).intValue();
    }
    return defaultValue;
  }

  /**
   * Gets a long.
   *
   * @param index the index
   * @return the long value, or {@code 0}
   */
  public long getLong(@Nonnegative final int index) {
    return this.getLong(index, 0L);
  }

  /**
   * Gets a long.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the long value, or {@code defaultValue}
   */
  public long getLong(@Nonnegative final int index, final long defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).longValue();
    }
    return defaultValue;
  }

  /**
   * Gets a float.
   *
   * @param index the index
   * @return the float value, or {@code 0}
   */
  public float getFloat(@Nonnegative final int index) {
    return this.getFloat(index, 0f);
  }

  /**
   * Gets a float.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the float value, or {@code defaultValue}
   */
  public float getFloat(@Nonnegative final int index, final float defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).floatValue();
    }
    return defaultValue;
  }

  /**
   * Gets a double.
   *
   * @param index the index
   * @return the double value, or {@code 0}
   */
  public double getDouble(@Nonnegative final int index) {
    return this.getDouble(index, 0d);
  }

  /**
   * Gets a double.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the double value, or {@code defaultValue}
   */
  public double getDouble(@Nonnegative final int index, final double defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type().number()) {
      return ((NumberTag) tag).doubleValue();
    }
    return defaultValue;
  }

  /**
   * Gets an array of bytes.
   *
   * @param index the index
   * @return the array of bytes, or a zero-length array
   */
  @Nonnull
  public byte[] getByteArray(@Nonnegative final int index) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.BYTE_ARRAY) {
      return ((ByteArrayTag) tag).value();
    }
    return new byte[0];
  }

  /**
   * Gets an array of bytes.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the array of bytes, or {@code defaultValue}
   */
  @Nonnull
  public byte[] getByteArray(@Nonnegative final int index, @Nonnull final byte[] defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.BYTE_ARRAY) {
      return ((ByteArrayTag) tag).value();
    }
    return defaultValue;
  }

  /**
   * Gets a string.
   *
   * @param index the index
   * @return the string value, or {@code ""}
   */
  @Nonnull
  public String getString(@Nonnegative final int index) {
    return this.getString(index, "");
  }

  /**
   * Gets a string.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the string value, or {@code defaultValue}
   */
  @Nonnull
  public String getString(@Nonnegative final int index, @Nonnull final String defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.STRING) {
      return ((StringTag) tag).value();
    }
    return defaultValue;
  }

  /**
   * Gets a compound.
   *
   * @param index the index
   * @return the compound, or a new compound
   */
  @Nonnull
  public CompoundTag getCompound(@Nonnegative final int index) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.COMPOUND) {
      return (CompoundTag) tag;
    }
    return new CompoundTag();
  }

  /**
   * Gets a compound.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the compound, or {@code defaultValue}
   */
  @Nonnull
  public CompoundTag getCompound(@Nonnegative final int index, @Nonnull final CompoundTag defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.COMPOUND) {
      return (CompoundTag) tag;
    }
    return defaultValue;
  }

  /**
   * Gets an array of ints.
   *
   * @param index the index
   * @return the array of ints, or a zero-length array
   */
  public int[] getIntArray(@Nonnegative final int index) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.INT_ARRAY) {
      return ((IntArrayTag) tag).value();
    }
    return new int[0];
  }

  /**
   * Gets an array of ints.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the array of ints, or {@code defaultValue}
   */
  @Nonnull
  public int[] getIntArray(@Nonnegative final int index, @Nonnull final int[] defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.INT_ARRAY) {
      return ((IntArrayTag) tag).value();
    }
    return defaultValue;
  }

  /**
   * Gets an array of longs.
   *
   * @param index the index
   * @return the array of longs, or a zero-length array
   */
  @Nonnull
  public long[] getLongArray(@Nonnegative final int index) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.LONG_ARRAY) {
      return ((LongArrayTag) tag).value();
    }
    return new long[0];
  }

  /**
   * Gets an array of longs.
   *
   * @param index the index
   * @param defaultValue the default value
   * @return the array of longs, or {@code defaultValue}
   */
  @Nonnull
  public long[] getLongArray(@Nonnegative final int index, @Nonnull final long[] defaultValue) {
    final Tag tag = this.get(index);
    if(tag.type() == TagType.LONG_ARRAY) {
      return ((LongArrayTag) tag).value();
    }
    return defaultValue;
  }

  /**
   * Adds a tag.
   *
   * @param tag the tag
   */
  public void add(@Nonnull final Tag tag) {
    // don't allow an end tag to be added
    if(tag.type() == TagType.END) {
      throw new IllegalArgumentException(String.format("Cannot add a '%s' to a '%s'", EndTag.class.getSimpleName(), ListTag.class.getSimpleName()));
    }
    // set the type if it has not yet been set
    if(this.type == TagType.END) {
      this.type = tag.type();
    }
    this.tags.add(tag);
  }

  /**
   * Sets the tag at the specified index.
   *
   * @param index the index
   * @param tag the tag
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  public void set(final int index, @Nonnull final Tag tag) {
    // don't allow an end tag to be added
    if(tag.type() == TagType.END) {
      throw new IllegalArgumentException(String.format("Cannot add a '%s' to a '%s'", EndTag.class.getSimpleName(), ListTag.class.getSimpleName()));
    }
    // set the type if it has not yet been set
    if(this.type == TagType.END) {
      this.type = tag.type();
    }
    this.tags.set(index, tag);
  }

  /**
   * Removes a tag.
   *
   * @param index the index
   * @return the tag
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  @Nonnull
  public Tag remove(final int index) {
    return this.tags.remove(index);
  }

  @Override
  protected void read(final DataInput input) throws IOException {
    this.type = TagType.of(input.readByte());

    final int length = input.readInt();
    for(int i = 0; i < length; i++) {
      final Tag tag = this.type.create();
      tag.read(input);
      this.tags.add(tag);
    }
  }

  @Override
  protected void write(final DataOutput output) throws IOException {
    output.writeByte(this.type.id());
    output.writeInt(this.tags.size());
    for(int i = 0, length = this.tags.size(); i < length; i++) {
      this.tags.get(i).write(output);
    }
  }

  @Nonnull
  @Override
  public TagType type() {
    return TagType.LIST;
  }

  @Override
  public int hashCode() {
    return this.tags.hashCode();
  }

  @Override
  public boolean equals(final Object that) {
    return this == that || (that instanceof ListTag && this.tags.equals(((ListTag) that).tags));
  }
}
