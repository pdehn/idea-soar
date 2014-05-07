package com.pdehaan.idea.soar;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.pdehaan.idea.soar.psi.SoarTypes.*;

%%

%{
  public _SoarLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SoarLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

VARIABLE=<[a-zA-Z0-9$%&*+-/:=?_]+>
FLOAT_CONSTANT=[+-]?[0-9]+\.[0-9]*
INT_CONSTANT=[+-]?[0-9]+
SYM_CONSTANT=[a-zA-Z0-9\$\%\&\*\+\-\/\=\?\_][a-zA-Z0-9\$\%\&\*\+\-\/\:\=\?\_]*|\|[^\|]*\|
LINE_COMMENT=#.*
STRING=\"[^\"]*\"

%%
<YYINITIAL> {
  {WHITE_SPACE}         { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "-->"                 { return RARROW; }
  "<=>"                 { return SAME_TYPE; }
  ">="                  { return GEQUAL; }
  "<<"                  { return LDISJUNCT; }
  "<="                  { return LEQUAL; }
  "<>"                  { return NEQUAL; }
  ">>"                  { return RDISJUNCT; }
  "&"                   { return AMPERSAND; }
  "@"                   { return ATSIGN; }
  "^"                   { return CARET; }
  ","                   { return COMMA; }
  "!"                   { return EMARK; }
  "="                   { return EQUAL; }
  ">"                   { return GREATER; }
  "-"                   { return HYPHEN; }
  "{"                   { return LBRACE; }
  "<"                   { return LESS; }
  "("                   { return LPAREN; }
  "."                   { return PERIOD; }
  "+"                   { return PLUS; }
  "?"                   { return QMARK; }
  "}"                   { return RBRACE; }
  ")"                   { return RPAREN; }
  "~"                   { return TILDE; }
  "["                   { return LSQBRACET; }
  "]"                   { return RSQBRACET; }
  "\""                  { return QUOTE; }

  {VARIABLE}            { return VARIABLE; }
  {FLOAT_CONSTANT}      { return FLOAT_CONSTANT; }
  {INT_CONSTANT}        { return INT_CONSTANT; }
  {SYM_CONSTANT}        { return SYM_CONSTANT; }
  {LINE_COMMENT}        { return LINE_COMMENT; }
  {STRING}              { return STRING; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
