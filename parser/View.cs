using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MashupParser
{
    class View
    {
        public static int TYPE_BUTTON_PARSED = 0;
        public static int TYPE_TEXTVIEW_PARSED = 1;
        public static string TYPE_BUTTON = "Button";
        public static string TYPE_TEXTVIEW = "TextView";
        public static string ATTRIBUTE_TEXT = "android:text";
        public static string ATTRIBUTE_ACTION = "android:onClick";
    }
}
