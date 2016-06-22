To add your Scala group to [Scala Space](http://scala.space), add an item to the collection in ```data/groups.json``` with the following five elements: group name, Meetup group ID or full URL, latitude and longitude of the place where you usually meet, and `true` if the group is a purely Scala group, or `false` if it's a more general FP group.

The easiest way to find these is to do a Google search for "coordinates of [place name]", and to reformat the response as real numbers, remembering to negate longitudes in the Western Hemisphere, and latitudes in the Southern Hemisphere.

For example, searching for "coordinates of Brighton" returns the response "50.8429° N, 0.1313° W". This should be translated to the following entry:

    {
      name: "Brighton Scala Users Group",
      url: "http://example.com/",
      latitude: 50.8429, 
      longitude: -0.1313, 
      justScala: true
    }

Try to keep the locations in alphabetical order of name.


[![Join the chat at https://gitter.im/scalaspace/scalaspace.github.io](https://badges.gitter.im/scalaspace/scalaspace.github.io.svg)](https://gitter.im/scalaspace/scalaspace.github.io?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)