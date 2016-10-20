using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace MashupParser
{
    class Program
    {
        static void Main(string[] args)
        {            
            string fileName = args[0];
            List<Activity> activities = GetParsedActivityFromFile(fileName);
            string activitiesJSON = JsonConvert.SerializeObject(activities);
            Console.WriteLine(activitiesJSON);
            Console.Read();                      
        }

        private static List<Activity> GetParsedActivityFromFile(string fileName)
        {
            List<Activity> activities = new List<Activity>();
            XmlTextReader reader = new XmlTextReader(fileName);
            while (reader.Read())
            {                
                switch (reader.NodeType)
                {
                    case XmlNodeType.Element:                         
                        if (reader.Name == View.TYPE_BUTTON)
                        {
                            Activity activity = new Activity();
                            activity.type = View.TYPE_BUTTON_PARSED;
                            while (reader.MoveToNextAttribute())
                            {
                                if (reader.Name == View.ATTRIBUTE_TEXT)
                                    activity.text = reader.Value;
                                if (reader.Name == View.ATTRIBUTE_ACTION)
                                    activity.action = reader.Value;                                
                            }
                            activities.Add(activity);
                        }
                                                
                        if (reader.Name == View.TYPE_TEXTVIEW)
                        {
                            Activity activity = new Activity();
                            activity.type = View.TYPE_TEXTVIEW_PARSED;
                            activity.action = "";
                            while (reader.MoveToNextAttribute())
                            {
                                if (reader.Name == View.ATTRIBUTE_TEXT)
                                    activity.text = reader.Value;
                            }
                            activities.Add(activity);
                        }                        
                        break;
                    case XmlNodeType.Text: 
                        Console.WriteLine(reader.Value);
                        break;
                    case XmlNodeType.EndElement: 
                        Console.Write("</" + reader.Name);
                        Console.WriteLine(">");
                        break;
                }                
            }
            return activities;   
        }
    }
}
