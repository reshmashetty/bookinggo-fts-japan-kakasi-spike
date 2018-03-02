Kakasi-java
Convert Japanese kanji into romaji
See also http://kakasi.namazu.org

Originally written by Tomoyuki Kawao
Forked from the last code found at http://blog.kenichimaehashi.com/?article=13048363750
If you know any more recent version, please let me know by email nicolas.raoul at gmail

To build just run: `ant`

Usage: 

    java -Dkakasi.home=. -jar lib/kakasi.jar [-JH | -JK | -Ja] [-HK | -Ha] [-KH | -Ka]
	[-i<input-encoding>] [-o<output-encoding>]
	[-p] [-f] [-c] [-s] [-b]
	[-r{hepburn|kunrei}] [-C | -U] [-w]
	[-F] [inputFileName]

	Character Set Conversions:
	 -JH: kanji to hiragana
	 -JK: kanji to katakana
	 -Ja: kanji to romaji
	 -HK: hiragana to katakana
	 -Ha: hiragana to romaji
	 -KH: katakana to hiragana
	 -Ka: katakana to romaji

	Options:
	 -i: input encoding
	 -o: output encoding
	 -p: list all readings (with -J option)
	 -f: furigana mode (with -J option)
	 -c: skip whitespace chars within jukugo
	 -s: insert separate characters
	 -b: output buffer is not flushed when a newline character is written
	 -r: romaji conversion system
	 -C: romaji Capitalize
	 -U: romaji Uppercase
	 -w: wakachigaki mode
	 -F: input through file. specify filename as last argument in list.

Example:

    java  -Dkakasi.home=. -jar lib/kakasi.jar -Ja
    国際財務報告基準
    kokusaizaimuhoukokukijun

Original documentation (in Japanese): http://nicolas-raoul.github.com/kakasi-java

<h3> Clone this repository and run on Intellij as below </h3>

1. To run jar using system input and convert all chars to Hiragana
![Alt text](RunJar_SysInput_AnythingToHiragana.png?raw=true "RunJar_SysInput_AnythingToHiragana")

2. To run jar using file input and convert all chars to Hiragana
![Alt text](RunJar_FileInput_AnythingToHiragana.png?raw=true "RunJar_FileInput_AnythingToHiragana")

3. To run jar using file input and convert all chars to Romaji/Latin/English
![Alt text](RunJar_FileInput_AnythingToRomajiLatin.png?raw=true "RunJar_FileInput_AnythingToRomajiLatin")
