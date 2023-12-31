package me.hugo.thankmas.smallcaps

import net.kyori.adventure.text.minimessage.Context
import net.kyori.adventure.text.minimessage.tag.Tag
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue

/**
 * Utility class for small caps.
 */
public class Alphabet {

    public companion object {
        private val REPLACEMENT_ALPHABET: CharArray = "ᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴘǫʀѕᴛᴜᴠᴡхʏᴢ".toCharArray()

        /** Converts the arguments passed into small caps using [convert]. */
        public fun convert(args: ArgumentQueue, context: Context): Tag {
            val text = args.popOr("No text provided for small_caps tag!").value()

            return Tag.preProcessParsed(convert(text))
        }

        /** Converts the [input] into small caps. */
        private fun convert(input: String): String {
            val builder: StringBuilder = StringBuilder()
            val chars = input.lowercase().toCharArray()

            chars.forEach {
                val index = (it - 97).code

                if (index >= 0 && index < REPLACEMENT_ALPHABET.size) {
                    builder.append(REPLACEMENT_ALPHABET[index])
                } else builder.append(it)
            }

            return builder.toString()
        }
    }
}