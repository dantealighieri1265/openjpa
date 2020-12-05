/* Generated By:JavaCC: Do not edit this line. JPQLTreeConstants.java Version 5.0 */
package org.apache.openjpa.kernel.jpql;

public interface JPQLTreeConstants
{
  public int JJTVOID = 0;
  public int JJTSELECT = 1;
  public int JJTUPDATE = 2;
  public int JJTDELETE = 3;
  public int JJTFROM = 4;
  public int JJTFROMITEM = 5;
  public int JJTINNERJOIN = 6;
  public int JJTOUTERJOIN = 7;
  public int JJTOUTERFETCHJOIN = 8;
  public int JJTINNERFETCHJOIN = 9;
  public int JJTPATH = 10;
  public int JJTUPDATEITEM = 11;
  public int JJTUPDATEVALUE = 12;
  public int JJTSELECTCLAUSE = 13;
  public int JJTSELECTEXPRESSIONS = 14;
  public int JJTSELECTEXPRESSION = 15;
  public int JJTSELECTEXTENSION = 16;
  public int JJTCONSTRUCTOR = 17;
  public int JJTCLASSNAME = 18;
  public int JJTCONSTRUCTORPARAMS = 19;
  public int JJTCONSTRUCTORPARAM = 20;
  public int JJTAGGREGATE = 21;
  public int JJTDISTINCT = 22;
  public int JJTDISTINCTPATH = 23;
  public int JJTCOUNT = 24;
  public int JJTAVERAGE = 25;
  public int JJTMAX = 26;
  public int JJTMIN = 27;
  public int JJTSUM = 28;
  public int JJTWHERE = 29;
  public int JJTGROUPBY = 30;
  public int JJTGROUPBYEXTENSION = 31;
  public int JJTHAVING = 32;
  public int JJTSUBSELECT = 33;
  public int JJTOR = 34;
  public int JJTAND = 35;
  public int JJTNOT = 36;
  public int JJTBETWEEN = 37;
  public int JJTIN = 38;
  public int JJTTYPELITERAL = 39;
  public int JJTLIKE = 40;
  public int JJTISNULL = 41;
  public int JJTISEMPTY = 42;
  public int JJTMEMBEROF = 43;
  public int JJTEXISTS = 44;
  public int JJTANY = 45;
  public int JJTALL = 46;
  public int JJTEQUALS = 47;
  public int JJTNOTEQUALS = 48;
  public int JJTGREATERTHAN = 49;
  public int JJTGREATEROREQUAL = 50;
  public int JJTLESSTHAN = 51;
  public int JJTLESSOREQUAL = 52;
  public int JJTADD = 53;
  public int JJTSUBTRACT = 54;
  public int JJTMULTIPLY = 55;
  public int JJTDIVIDE = 56;
  public int JJTQUALIFIEDPATH = 57;
  public int JJTKEY = 58;
  public int JJTQUALIFIEDIDENTIFIER = 59;
  public int JJTVALUE = 60;
  public int JJTENTRY = 61;
  public int JJTGENERALIDENTIFIER = 62;
  public int JJTTYPE = 63;
  public int JJTSCALAREXPRESSION = 64;
  public int JJTCASE = 65;
  public int JJTGENERALCASE = 66;
  public int JJTWHEN = 67;
  public int JJTSIMPLECASE = 68;
  public int JJTWHENSCALAR = 69;
  public int JJTCOALESCE = 70;
  public int JJTNULLIF = 71;
  public int JJTNEGATIVE = 72;
  public int JJTCONCAT = 73;
  public int JJTSUBSTRING = 74;
  public int JJTTRIM = 75;
  public int JJTLOWER = 76;
  public int JJTUPPER = 77;
  public int JJTTRIMLEADING = 78;
  public int JJTTRIMTRAILING = 79;
  public int JJTTRIMBOTH = 80;
  public int JJTLENGTH = 81;
  public int JJTLOCATE = 82;
  public int JJTABS = 83;
  public int JJTSQRT = 84;
  public int JJTMOD = 85;
  public int JJTSIZE = 86;
  public int JJTINDEX = 87;
  public int JJTCURRENTDATE = 88;
  public int JJTCURRENTTIME = 89;
  public int JJTCURRENTTIMESTAMP = 90;
  public int JJTORDERBY = 91;
  public int JJTORDERBYITEM = 92;
  public int JJTASCENDING = 93;
  public int JJTDESCENDING = 94;
  public int JJTORDERBYEXTENSION = 95;
  public int JJTABSTRACTSCHEMANAME = 96;
  public int JJTTOK = 97;
  public int JJTIDENTIFIER = 98;
  public int JJTIDENTIFICATIONVARIABLE = 99;
  public int JJTINTEGERLITERAL = 100;
  public int JJTDECIMALLITERAL = 101;
  public int JJTBOOLEANLITERAL = 102;
  public int JJTSTRINGLITERAL = 103;
  public int JJTSTRINGLITERAL2 = 104;
  public int JJTDATELITERAL = 105;
  public int JJTTIMELITERAL = 106;
  public int JJTTIMESTAMPLITERAL = 107;
  public int JJTCOLLECTIONPARAMETER = 108;
  public int JJTNAMEDINPUTPARAMETER = 109;
  public int JJTPOSITIONALINPUTPARAMETER = 110;
  public int JJTPATTERNVALUE = 111;
  public int JJTESCAPECHARACTER = 112;
  public int JJTTRIMCHARACTER = 113;


  public String[] jjtNodeName = {
    "void",
    "SELECT",
    "UPDATE",
    "DELETE",
    "FROM",
    "FROMITEM",
    "INNERJOIN",
    "OUTERJOIN",
    "OUTERFETCHJOIN",
    "INNERFETCHJOIN",
    "PATH",
    "UPDATEITEM",
    "UPDATEVALUE",
    "SELECTCLAUSE",
    "SELECTEXPRESSIONS",
    "SELECTEXPRESSION",
    "SELECTEXTENSION",
    "CONSTRUCTOR",
    "CLASSNAME",
    "CONSTRUCTORPARAMS",
    "CONSTRUCTORPARAM",
    "AGGREGATE",
    "DISTINCT",
    "DISTINCTPATH",
    "COUNT",
    "AVERAGE",
    "MAX",
    "MIN",
    "SUM",
    "WHERE",
    "GROUPBY",
    "GROUPBYEXTENSION",
    "HAVING",
    "SUBSELECT",
    "OR",
    "AND",
    "NOT",
    "BETWEEN",
    "IN",
    "TYPELITERAL",
    "LIKE",
    "ISNULL",
    "ISEMPTY",
    "MEMBEROF",
    "EXISTS",
    "ANY",
    "ALL",
    "EQUALS",
    "NOTEQUALS",
    "GREATERTHAN",
    "GREATEROREQUAL",
    "LESSTHAN",
    "LESSOREQUAL",
    "ADD",
    "SUBTRACT",
    "MULTIPLY",
    "DIVIDE",
    "QUALIFIEDPATH",
    "KEY",
    "QUALIFIEDIDENTIFIER",
    "VALUE",
    "ENTRY",
    "GENERALIDENTIFIER",
    "TYPE",
    "SCALAREXPRESSION",
    "CASE",
    "GENERALCASE",
    "WHEN",
    "SIMPLECASE",
    "WHENSCALAR",
    "COALESCE",
    "NULLIF",
    "NEGATIVE",
    "CONCAT",
    "SUBSTRING",
    "TRIM",
    "LOWER",
    "UPPER",
    "TRIMLEADING",
    "TRIMTRAILING",
    "TRIMBOTH",
    "LENGTH",
    "LOCATE",
    "ABS",
    "SQRT",
    "MOD",
    "SIZE",
    "INDEX",
    "CURRENTDATE",
    "CURRENTTIME",
    "CURRENTTIMESTAMP",
    "ORDERBY",
    "ORDERBYITEM",
    "ASCENDING",
    "DESCENDING",
    "ORDERBYEXTENSION",
    "ABSTRACTSCHEMANAME",
    "TOK",
    "IDENTIFIER",
    "IDENTIFICATIONVARIABLE",
    "INTEGERLITERAL",
    "DECIMALLITERAL",
    "BOOLEANLITERAL",
    "STRINGLITERAL",
    "STRINGLITERAL2",
    "DATELITERAL",
    "TIMELITERAL",
    "TIMESTAMPLITERAL",
    "COLLECTIONPARAMETER",
    "NAMEDINPUTPARAMETER",
    "POSITIONALINPUTPARAMETER",
    "PATTERNVALUE",
    "ESCAPECHARACTER",
    "TRIMCHARACTER",
  };
}
/* JavaCC - OriginalChecksum=683495e3ca0cd36faeccaa54212946f8 (do not edit this line) */
